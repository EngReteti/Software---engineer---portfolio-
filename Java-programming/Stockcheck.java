public class Main {
    public static void main(String[] args) {
        // We set the value here so no 'Input' is needed
        int quantity = 9; 
        String medicineName = "Paracetamol";

        System.out.println("Checking " + medicineName + " ");
        
        if (quantity <= 0) {
            System.out.println("Status: OUT OF STOCK!");
        } else if (quantity < 10) {
            System.out.println("Status: WARNING - Low Stock.");
        } else {
            System.out.println("Status: Stock level is healthy (" + quantity + " units).");
        }
    }
}
