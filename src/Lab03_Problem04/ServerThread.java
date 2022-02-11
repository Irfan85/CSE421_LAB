package Lab03_Problem04;

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
				String mode = reader.readLine();

				if (mode.equalsIgnoreCase("exit")) {
					writer.println("Good Bye");
					break;
				} else {
					double a = Double.parseDouble(reader.readLine());
					double b = Double.parseDouble(reader.readLine());

					double result = calculate(Integer.parseInt(mode), a, b);
					writer.println("Answer: " + result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private double calculate(int mode, double a, double b) {
		switch (mode) {
		case 1:
			return a + b;
		case 2:
			return a - b;
		case 3:
			return a * b;
		default:
			return 0.0;
		}
	}
}
