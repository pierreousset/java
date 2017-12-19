package domain;

import javax.validation.constraints.NotBlank;

public class Product {

    private static String NAME_PATTERN = "%s %s %s";

    @NotBlank
    private String productName;
    @NotBlank
    private int quantityProduct;
    @NotBlank
    private double priceProduct;

    public Product(String productName, int quantityProduct, double priceProduct){
        this.productName = productName;
        this.quantityProduct = quantityProduct;
        this.priceProduct = priceProduct;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }
}
