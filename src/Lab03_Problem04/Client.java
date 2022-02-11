package Lab03_Problem04;

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
				System.out.println("Press 1 for summation");
				System.out.println("Press 2 for subtraction");
				System.out.println("Press 3 for multiplication");
				System.out.println("Type 'exit' to exit the program");

				System.out.print("Mode: ");
				String mode = scanner.nextLine();

				if (mode.equalsIgnoreCase("exit")) {
					writer.println("exit");
					String goodByeMessage = reader.readLine();
					System.out.println(goodByeMessage);

					break;
				} else if (mode.equals("1") || mode.equals("2") || mode.equals("3")) {
					writer.println(mode);

					System.out.print("Enter first operand: ");
					String firstOperand = scanner.nextLine();
					writer.println(firstOperand);

					System.out.print("Enter second operand: ");
					String secondOperand = scanner.nextLine();
					writer.println(secondOperand);

					String result = reader.readLine();
					System.out.println("Result: " + result);
				} else {
					System.out.println("Invalid Input. Please try again");
				}
			}

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
