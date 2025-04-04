package service;

import entity.product;

abstract public class NonExpirableProduct extends product {

    public NonExpirableProduct(String name, double price, int availableQuantity) {
        super(name, price, availableQuantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }


}
