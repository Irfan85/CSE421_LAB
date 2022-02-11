package Lab03_Problem03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
