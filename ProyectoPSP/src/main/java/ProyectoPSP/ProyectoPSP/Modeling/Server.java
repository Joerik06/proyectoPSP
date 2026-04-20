package ProyectoPSP.ProyectoPSP.Modeling;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2000);
            System.out.println("Servidor iniciado en el puerto 2000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado");

                handleClient cliente = new handleClient(socket);
                Thread hilo = new Thread(cliente);
                hilo.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
