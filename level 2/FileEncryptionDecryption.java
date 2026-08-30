import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== File Encryption/Decryption ===");

        System.out.print("Enter E for Encryption or D for Decryption: ");
        char choice = sc.next().toUpperCase().charAt(0);

        sc.nextLine();

        System.out.print("Enter the input file path: ");
        String inputFile = sc.nextLine();

        System.out.print("Enter the output file path: ");
        String outputFile = sc.nextLine();

        int key = 3;

        try {
            FileReader reader = new FileReader(inputFile);
            FileWriter writer = new FileWriter(outputFile);

            int character;

            while ((character = reader.read()) != -1) {

                if (choice == 'E') {
                    writer.write(character + key);
                } 
                else if (choice == 'D') {
                    writer.write(character - key);
                } 
                else {
                    System.out.println("Invalid choice!");
                    reader.close();
                    writer.close();
                    sc.close();
                    return;
                }
            }

            reader.close();
            writer.close();

            if (choice == 'E') {
                System.out.println("File encrypted successfully!");
            } else {
                System.out.println("File decrypted successfully!");
            }

            System.out.println("Output saved to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}