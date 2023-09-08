package first;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to the server's IP address or hostname
        int serverPort = 54321; // Change this to the server's port number

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket(serverAddress, serverPort);

            // Create input and output streams for communication with the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Take input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            // Send the number to the server
            out.println(number);

            // Receive and print the result from the server
            String result = in.readLine();
            System.out.println("Server response: " + result);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
