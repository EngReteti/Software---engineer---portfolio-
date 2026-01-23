import java.io.*;
import java.net.*;

public class SimpleNexus {
    public static void main(String[] args) {
        // Start Server Thread
        new Thread(() -> {
            try (ServerSocket server = new ServerSocket(5000)) {
                System.out.println("[SERVER] Reteti Bank Vault is OPEN...");
                Socket socket = server.accept(); // Wait for client
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("[SERVER] Message Received: " + in.readLine());
            } catch (Exception e) { e.printStackTrace(); }
        }).start();

        // Start Client Thread
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Wait for server to wake up
                Socket client = new Socket("127.0.0.1", 5000);
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println("ALERT: Secure Connection Established!");
                client.close();
            } catch (Exception e) { e.printStackTrace(); }
        }).start();
    }
}
