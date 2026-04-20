package ProyectoPSP.ProyectoPSP.Modeling;

import java.io.*;
import java.net.Socket;

public class handleClient implements Runnable {

	private Socket socket;
	private String nombre;

	public handleClient(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			salida.println("Hola, introduce tu nombre:");
			nombre = entrada.readLine();

			salida.println("Hola " + nombre + ", ya estás conectado.");

			String opcion;

			do {
				salida.println("MENU");
				salida.println("1. Denunciar");
				salida.println("2. Información");
				salida.println("3. Salir");
				salida.println("END");

				opcion = entrada.readLine();
				System.out.println(opcion);

				switch (opcion) {
				case "1":
					salida.print("Has seleccionado denunciar una situación\n");
					break;

				case "2":
					salida.print("Este sistema permite reportar situaciones de bullying de forma anónima.");
					break;

				case "3":
					salida.println("Desconectando...");
					salida.println("END");
					break;

				default:
					salida.println("Opción no válida");
					break;
				}

			} while (!opcion.equalsIgnoreCase("salir"));

			System.out.println(nombre + " se ha desconectado");
			socket.close();

		} catch (Exception e) {
			System.out.println("Error con cliente");
		}
	}
}