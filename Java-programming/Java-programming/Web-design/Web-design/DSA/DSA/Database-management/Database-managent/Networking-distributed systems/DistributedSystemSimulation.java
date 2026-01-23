import java.util.*;

class Node {
    int id;
    String data = "Empty";

    Node(int id) { this.id = id; }

    // Leader: Updates itself and pushes to followers
    void write(String val, Node... followers) {
        this.data = val;
        System.out.println("Leader[" + id + "] saved: " + val);
        for (Node f : followers) f.sync(val);
    }

    // Follower: Receives data from leader
    void sync(String val) {
        this.data = val;
        System.out.println("Node[" + id + "] synced: " + data);
    }
}

public class Main {
    public static void main(String[] args) {
        // Init 3 nodes
        Node n0 = new Node(0); // Leader
        Node n1 = new Node(1); // Follower
        Node n2 = new Node(2); // Follower

        // Task: Leader writes data and propagates
        n0.write("Verified_Data_2026", n1, n2);

        // Print final states to verify
        System.out.println("\nCluster State: [" + n0.data + ", " + n1.data + ", " + n2.data + "]");
    }
}
