package Lab03_Problem02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

				InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
				BufferedReader reader = new BufferedReader(inputStreamReader);

				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				PrintWriter writer = new PrintWriter(outputStream, true);

				while (true) {
					String clientMessage = reader.readLine();

					if (clientMessage.equalsIgnoreCase("end game")) {
						writer.println("Good Bye");
						break;
					} else {
						writer.println(clientMessage);
					}
				}

				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
