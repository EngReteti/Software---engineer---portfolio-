import java.io.*;
import java.net.*;
import java.util.Random;

public class RetetiBankFinal {
    public static void main(String[] args) {
        // 1. THE CENTRAL SERVER THREAD (The Bank)
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8000)) {
                System.out.println("[BANK] Reteti Central is ONLINE on Port 8000.");
                System.out.println("[BANK] Awaiting customer transactions...\n");

                while (true) {
                    // Wait for a connection
                    Socket clientSocket = serverSocket.accept();
                    
                    // Spawn a unique thread for every single customer
                    new Thread(new TransactionHandler(clientSocket)).start();
                }
            } catch (IOException e) {
                System.err.println("Bank System Error: " + e.getMessage());
            }
        }).start();

        // 2. SIMULATING MULTIPLE CUSTOMERS (The Clients)
        String[] customers = {"Alice_CUK", "Bob_CUK", "Charlie_CUK", "Diana_CUK"};

        for (String name : customers) {
            new Thread(() -> {
                try {
                    // Stagger connections so they don't all hit at the exact same microsecond
                    Thread.sleep(new Random().nextInt(3000)); 

                    // Connect to the bank
                    Socket socket = new Socket("127.0.0.1", 8000);
                    
                    // Setup communication channels
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    // CLIENT SENDS: A request
                    out.println("DEPOSIT_REQUEST from " + name);
                    System.out.println("[CLIENT] " + name + ": Sent request to bank.");

                    // CLIENT RECEIVES: Feedback from server
                    String response = in.readLine();
                    System.out.println("[CLIENT] " + name + " Received: " + response);

                    socket.close();
                } catch (Exception e) {
                    System.err.println("Client Connection Error: " + e.getMessage());
                }
            }).start();
        }
    }
}

// 3. THE HANDLER: Logic for providing feedback to each client
class TransactionHandler implements Runnable {
    private Socket socket;

    public TransactionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Setup streams for this specific client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the customer's request
            String request = in.readLine();
            System.out.println("[SERVER LOG] Processing " + request + "...");

            // Simulate processing time
            Thread.sleep(1000);

            // SEND FEEDBACK: Give a unique response back to the specific client
            String transactionID = "TXN" + new Random().nextInt(90000);
            out.println("Reteti Bank: Success! Transaction " + transactionID + " confirmed.");

            socket.close(); // Close the connection after feedback is sent
        } catch (Exception e) {
            System.err.println("Transaction Handler Error: " + e.getMessage());
        }
    }
}
