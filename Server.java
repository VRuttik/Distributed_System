package first;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int PORT = 54321; // Port number to listen on

        try {
            // Open the Server Socket
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Wait for the Client Request
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress());

                // Create I/O streams for communicating with the client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Receive the number from the client
                int number = Integer.parseInt(in.readLine());

                // Calculate the sum of digits
                int remainder, sumOfDigits = 0;
                int originalNumber = number;

                while (number > 0) {
                    remainder = number % 10;
                    sumOfDigits = sumOfDigits + remainder;
                    number = number / 10;
                }

                // Send the result back to the client
                out.println("Sum of digits of " + originalNumber + " is: " + sumOfDigits);

                // Close the socket
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
