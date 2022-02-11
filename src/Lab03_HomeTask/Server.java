package Lab03_HomeTask;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int PORT_NUMBER = 7777;

	public static void main(String[] args) {
		try {
			while (true) {
				ServerSocket ss = new ServerSocket(PORT_NUMBER);
				System.out.println("Server has started and running at port: " + PORT_NUMBER);
				Socket socket = ss.accept();
				System.out.println("Client connected");

				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();

				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
