package ProyectoPSP.ProyectoPSP.Modeling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class cliente {
	
	public static void main(String[] args) {
		try {
			Socket socket= new Socket("localhost",2000);
			DataInputStream entrada= new DataInputStream(socket.getInputStream());
			
			String message= entrada.readUTF();
			System.out.println(message);
			socket.close();
		} catch (IOException e) {
			System.out.println("Erro al intentar conectar");
		}
		
		

	}
}
