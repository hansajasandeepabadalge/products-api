// A PhysicalProduct IS-A Product because it inherits the common properties and behaviours of a Product, such as id, name, and price.
// If there is a ShoppingCart, it is not a Product because it HAS-A relationship with Products by containing multiple products.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
