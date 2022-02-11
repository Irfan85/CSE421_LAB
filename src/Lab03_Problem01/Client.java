package Lab03_Problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	private static final int PORT_NUMBER = 7777;

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", PORT_NUMBER);

			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(inputStreamReader);

			System.out.println("Response: " + reader.readLine());

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
