import java.io.*;
import java.net.*;

public class RetetiCentralServer {
    public static void main(String[] args) {
        // SERVER PORTION
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(7000)) {
                System.out.println("[BANK] Reteti Central is running on Port 7000...");
                while (true) {
                    Socket client = serverSocket.accept();
                    // Handle each client in a NEW THREAD (Concurrency)
                    new Thread(new ClientHandler(client)).start();
                }
            } catch (Exception e) { e.printStackTrace(); }
        }).start();

        // SIMULATING 3 DIFFERENT CUSTOMERS (CLIENTS)
        for (int i = 1; i <= 3; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1500 * id); // Staggered connections
                    Socket s = new Socket("127.0.0.1", 7000);
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                    out.println("Customer #" + id + " is checking records.");
                    s.close();
                } catch (Exception e) { e.printStackTrace(); }
            }).start();
        }
    }
}

// THIS CLASS HANDLES INDIVIDUAL CLIENTS
class ClientHandler implements Runnable {
    private Socket socket;
    public ClientHandler(Socket s) { this.socket = s; }
    
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("[CENTRAL BANK LOG] " + in.readLine());
            socket.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
