package service;


import entity.product;

abstract public class ExpirableProduct extends product {

    private java.time.LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int availableQuantity, java.time.LocalDate expiryDate) {
        super(name, price, availableQuantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return java.time.LocalDate.now().isAfter(expiryDate);
    }
}
