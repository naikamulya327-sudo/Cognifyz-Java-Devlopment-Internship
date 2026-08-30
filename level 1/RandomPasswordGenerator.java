import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special = "!@#$%^&*";

        String characters = "";

        System.out.println("=== Random Password Generator ===");

        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        System.out.print("Include lowercase letters? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            characters += lowercase;
        }

        System.out.print("Include uppercase letters? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            characters += uppercase;
        }

        System.out.print("Include numbers? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            characters += numbers;
        }

        System.out.print("Include special characters? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            characters += special;
        }

        if (characters.isEmpty()) {
            System.out.println("Please select at least one character type.");
        } else {
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                password.append(characters.charAt(index));
            }

            System.out.println("Generated Password: " + password);
        }

        sc.close();
    }
}