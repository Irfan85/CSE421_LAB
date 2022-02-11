package Lab03_HomeTask;

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
				
				if(clientMessage == null) {
					break;
				}
				
				for (char c : clientMessage.toCharArray()) {
					writer.println("ASCII code of '" + c + "' is: " + (int) c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
