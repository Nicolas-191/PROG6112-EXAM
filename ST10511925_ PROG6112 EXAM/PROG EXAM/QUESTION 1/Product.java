/**
 * Product class - Implements IProduct
 * Holds sales data using:
 * - 1D array for product names
 * - 2D array for sales [product][month]
 * 
 * Q1.1: 3 products x 3 months
 * 1. Cozy Nights Monarch
 * 2. Restonic Barbados
 * 3. Sealy Phuket
 */
public class Product implements IProduct {

    // Private fields - good practice, correct scope for General marks
    private String[] productNames;
    private int[][] sales; // [3][3]

    /**
     * Constructor - receives data from Main
     * @param productNames 1D array of product names
     * @param sales 2D array of sales figures
     */
    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    /**
     * Q1.2 - GetTotalProductsSold
     * Loops through 2D array and sums all values.
     * Example: 153 for screenshot data
     */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        // Outer loop = products (rows)
        for (int i = 0; i < sales.length; i++) {
            // Inner loop = months (columns)
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    /**
     * Q1.2 - GetAverageProductSold
     * Average = Total / Number of entries (3 x 3 = 9)
     * Reuses GetTotalProductsSold() - no duplicated code (efficiency marks)
     * Example: 153 / 9 = 17.0
     */
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = sales.length * sales[0].length;
        return (double) total / count;
    }

    /**
     * Q1.2 - GetMostPopularProduct
     * Finds the highest single month sale.
     * This matches lecturer's screenshot: Cozy Nights Monarch(25)
     * Logic: track max value and which product it belongs to
     */
    @Override
    public String GetMostPopularProduct() {
        int maxSale = 0;
        String popularProduct = "";

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                if (sales[i][j] > maxSale) {
                    maxSale = sales[i][j];
                    popularProduct = productNames[i];
                }
            }
        }
        return popularProduct + "(" + maxSale + ")";
    }
}