import java.util.Scanner;

/**
 * Main - Q1.1
 * Captures user input and displays report.
 * Uses 1D + 2D arrays as required.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1D array - Product names
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // 2D array - [3 products][3 months]
        int[][] sales = new int[3][3];

        // Capture input: for each product, for each month
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) 
                    + " for " + products[i] + " mattress: ");
                sales[i][j] = sc.nextInt();
            }
            System.out.println(); // Blank line after each product
        }

        // Create Product object and Print it
        Product product = new Product(products, sales);
        PrintProduct printer = new PrintProduct(product);
        printer.PrintReport();

        sc.close();
    }
}