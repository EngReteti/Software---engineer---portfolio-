// 1. The Blueprint (Class)
class Medicine {
    String name;
    int stock;
    double price;

    // 2. The Constructor (Builds the medicine with values)
    Medicine(String n, int s, double p) {
        this.name = n;
        this.stock = s;
        this.price = p;
    }

    // 3. A Method (Action) to display the information
    void checkInventory() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        if (stock < 10) {
            System.out.println("ALERT: Low Stock (" + stock + " left)");
        } else {
            System.out.println("Stock Status: Healthy (" + stock + ")");
        }
        System.out.println("-----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // 4. Creating actual 'Objects' using our blueprint
        Medicine med1 = new Medicine("Paracetamol", 5, 2.50);
        Medicine med2 = new Medicine("Amoxicillin", 25, 12.00);

        System.out.println("--- Pharmacy OOP Management System ---");
        
        // 5. Running the actions
        med1.checkInventory();
        med2.checkInventory();
    }
}
