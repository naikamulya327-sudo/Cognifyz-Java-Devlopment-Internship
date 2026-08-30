import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Password Strength Checker ===");

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int score = 0;

        if (password.length() >= 8) {
            score++;
        }

        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        if (password.matches(".*[a-z].*")) {
            score++;
        }

        if (password.matches(".*[0-9].*")) {
            score++;
        }

        if (password.matches(".*[^a-zA-Z0-9].*")) {
            score++;
        }

        System.out.println();

        if (score == 5) {
            System.out.println("Password Strength: Strong");
        } else if (score >= 3) {
            System.out.println("Password Strength: Medium");
        } else {
            System.out.println("Password Strength: Weak");
        }

        System.out.println("Score: " + score + "/5");

        sc.close();
    }
}