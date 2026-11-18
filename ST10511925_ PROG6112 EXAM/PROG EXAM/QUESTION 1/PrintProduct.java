/**
 * PrintProduct class - Q1.3
 * Responsible ONLY for printing.
 * Takes IProduct (interface) not Product (class) - good OOP practice.
 */
public class PrintProduct {

    private IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    // Prints total - calls interface method
    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Prints average - casts to int to match screenshot: 17 not 17.0
    public void PrintAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
    }

    // Prints most popular product
    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    // Prints full report in correct order
    public void PrintReport() {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("************************************");
        PrintTotalProductSales();
        PrintAverageProductSales();
        PrintMostPopularProduct();
    }
}