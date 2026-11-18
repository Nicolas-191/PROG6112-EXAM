import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for Q1.4
 * Uses EXACT data from lecturer screenshot to prove correctness.
 * Screenshot data:
 * Cozy: 25, 18, 20
 * Restonic: 15, 10, 12
 * Sealy: 18, 15, 20
 * Total = 153, Average = 17.0
 */
public class ProductTest {

    private String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = new Product(names, sales);
        // Act
        int actual = product.GetTotalProductsSold();
        // Assert - must be 153
        assertEquals(153, actual);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = new Product(names, sales);
        // Act
        double actual = product.GetAverageProductSold();
        // Assert - must be 17.0, delta 0.01 for double comparison
        assertEquals(17.0, actual, 0.01);
    }
}