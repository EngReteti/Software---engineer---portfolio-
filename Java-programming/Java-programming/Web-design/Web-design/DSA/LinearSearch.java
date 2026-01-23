import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The array to search through
        int[] numbers = {101, 50, 89, 23, 77, 44};
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to search for: ");
        int target = input.nextInt();
        
        int foundIndex = -1; // Default to -1 if not found

        // Linear Search Algorithm
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                foundIndex = i; // Store the position (index)
                break; // Stop searching once we find it
            }
        }

        // Output results
        if (foundIndex != -1) {
            System.out.println("✅ Found! " + target + " is at index " + foundIndex);
        } else {
            System.out.println("❌ Sorry, " + target + " is not in the array.");
        }
    }
}
