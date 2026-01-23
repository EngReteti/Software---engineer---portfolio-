import java.io.*;
import java.net.*;

public class BankChat {
    public static void main(String[] args) {
        new Thread(() -> {
            try (ServerSocket server = new ServerSocket(6000)) {
                Socket s = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                
                String clientMsg = in.readLine();
                System.out.println("[SERVER] Customer asks: " + clientMsg);
                out.println("Reteti Bank: Your Balance is 50,000 KES.");
            } catch (Exception e) { e.printStackTrace(); }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Socket s = new Socket("127.0.0.1", 6000);
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                
                out.println("What is my balance?");
                System.out.println("[CLIENT] Bank Replied: " + in.readLine());
            } catch (Exception e) { e.printStackTrace(); }
        }).start();
    }
}
