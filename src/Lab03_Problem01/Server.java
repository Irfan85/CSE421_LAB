package Lab03_Problem01;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	private static final int PORT_NUMBER = 7777;

	public static void main(String[] args) {
		try {
			while (true) {
				ServerSocket ss = new ServerSocket(PORT_NUMBER);
				System.out.println("Server has started and running at port: " + PORT_NUMBER);
				Socket socket = ss.accept();
				System.out.println("Client connected");

				String today = new Date().toString();

				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				PrintWriter writer = new PrintWriter(outputStream, true);

				writer.println(today);

				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
