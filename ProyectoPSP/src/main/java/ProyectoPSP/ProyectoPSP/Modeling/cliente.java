package ProyectoPSP.ProyectoPSP.Modeling;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class cliente {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 2000);

			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

			Scanner scanner = new Scanner(System.in);

			String mensajeServidor;
			
			Boolean flag= true;
			
			mensajeServidor = entrada.readLine();
			System.out.println(mensajeServidor);
			String mensajeUsuario = scanner.nextLine();
			salida.println(mensajeUsuario);
			mensajeServidor = entrada.readLine();
			System.out.println(mensajeServidor);

			while (flag) {
				mensajeServidor = entrada.readLine();
				System.out.println(mensajeServidor);

				mensajeUsuario = scanner.nextLine();
				salida.println(mensajeUsuario);
				
				
				
				
				if (mensajeUsuario.equalsIgnoreCase("Salir")) {
					flag=false;
					salida.close();
					entrada.close();
				}else {
					mensajeServidor = entrada.readLine();
					System.out.println(mensajeServidor);
				}
				
			}

			socket.close();

		} catch (IOException e) {
			System.out.println("Error al conectar con el servidor");
		}
	}
}