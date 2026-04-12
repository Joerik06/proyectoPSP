package ProyectoPSP.ProyectoPSP.Modeling;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		int contador=1;
		try {
			ServerSocket server= new ServerSocket(2000);
			System.out.println("Servidor iniciado..... esperando clientes");
			while (contador<10) {
				Socket sClient= server.accept();
				server.setReuseAddress(true);
				System.out.println("nuevo cliente conectado");
				
				new Thread(new handleClient(sClient)).start();
			}
			
		server.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
