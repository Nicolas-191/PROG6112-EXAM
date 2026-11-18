/**
 * IProduct Interface
 * Defines the contract for all Product calculations.
 * Used to meet Q1.2 - Interface requirement for full marks.
 */
public interface IProduct {

    // Returns the sum of all products sold (all products x all months)
    int GetTotalProductsSold();

    // Returns the average number of products sold
    double GetAverageProductSold();

    // Returns the most popular product with its highest single sale
    // Example: Cozy Nights Monarch(25)
    String GetMostPopularProduct();
}