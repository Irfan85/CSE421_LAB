package Lab03_HomeTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private static final int PORT_NUMBER = 7777;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			Socket socket = new Socket("localhost", PORT_NUMBER);

			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(inputStreamReader);

			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			PrintWriter writer = new PrintWriter(outputStream, true);

			while (true) {
				System.out.print("Enter a message for server: ");
				String input = scanner.nextLine();
				writer.println(input);

				for (int i = 0; i < input.length(); i++) {
					String response = reader.readLine();
					System.out.println(response);
				}

				System.out.println("To continue the program press 'y': ");
				String continuationInput = scanner.nextLine();
				if (!continuationInput.equalsIgnoreCase("y")) {
					break;
				}
			}

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
