package ejercicio1cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Esta aplicación cliente-servidor está diseñada para enviar, recibir y leer un
 * mensaje tres veces. Este es el codigo del cliente que se encarga de crear el
 * socket, establecer la conexión y enviar el primer mensaje iniciando asi el
 * ciclo.
 *
 * @author Arturo
 */
public class Ejercicio1Cliente{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr=new InetSocketAddress("localhost", 6666);
            clienteSocket.connect(addr);

            InputStream is=clienteSocket.getInputStream();
            OutputStream os=clienteSocket.getOutputStream();

            //Bucle encargado de enviar y leer los mensajes
            for(int i=0; i<3; i++){

                System.out.println("Enviando mensaje");

                String mensaje="Mensaje cliente "+i;
                os.write(mensaje.getBytes());

                System.out.println("Mensaje enviado");

                byte[] mensaje2=new byte[25];
                is.read(mensaje2);

                System.out.println("Mensaje "+i+" recibido: "+new String(mensaje2));
            }
            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
