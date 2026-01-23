public class Main {
    public static void main(String[] args) {
        // Data Structure: An array of student marks
        int[] marks = {65, 82, 45, 98, 77};
        
        // 1. Task: Print array elements
        System.out.print("All Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }

        // 2. Task: Sum numbers
        int sum = 0;
        for (int mark : marks) {
            sum += mark; // Add each number to the 'sum' variable
        }
        System.out.println("\nTotal Sum of Marks: " + sum);

        // 3. Task: Find Max Value
        int max = marks[0]; // Assume the first number is the biggest initially
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i]; // If current number is bigger, update 'max'
            }
        }
        System.out.println("Highest (Maximum) Mark: " + max);
    }
}
