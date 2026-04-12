package ProyectoPSP.ProyectoPSP.Modeling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class handleClient implements Runnable{
	private Socket socket;
	private String nombre;


	public handleClient(Socket socket) {
		this.socket = socket;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream salida= new DataOutputStream(socket.getOutputStream()); 
			salida.writeUTF("Hola, Introduce tu nombre");
			nombre= entrada.readLine();
			System.out.println("Hola"+ nombre +", ya estas conectado. Escribe una accion");
			while ((entrada.readLine())!="salir") {
				
			}
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
