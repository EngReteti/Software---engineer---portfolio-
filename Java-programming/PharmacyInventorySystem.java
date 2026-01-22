// 1. The Blueprint for our Medicine
class Medicine {
    String name;
    int stock;
    double price;

    Medicine(String n, int s, double p) {
        this.name = n;
        this.stock = s;
        this.price = p;
    }

    void displayStatus() {
        System.out.print("Item: " + name + " | Stock: " + stock);
        
        // Control Flow logic inside the object
        if (stock <= 0) {
            System.out.println(" -> [CRITICAL: OUT OF STOCK]");
        } else if (stock < 10) {
            System.out.println(" -> [WARNING: LOW STOCK]");
        } else {
            System.out.println(" -> [OK: HEALTHY]");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 2. Creating an Array to hold our Pharmacy Inventory
        Medicine[] inventory = {
            new Medicine("Paracetamol", 50, 2.50),
            new Medicine("Amoxicillin", 4, 15.00),
            new Medicine("Insulin", 0, 45.00),
            new Medicine("Cough Syrup", 8, 7.25),
            new Medicine("Vitamin C", 100, 1.10)
        };

        System.out.println("========== PHARMACY MANAGEMENT SYSTEM ==========");
        
        // 3. The Loop: This automatically checks every item in the list
        for (int i = 0; i < inventory.length; i++) {
            inventory[i].displayStatus();
        }

        System.out.println("================================================");
    }
}
