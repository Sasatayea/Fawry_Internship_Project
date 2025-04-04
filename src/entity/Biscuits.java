package entity;

import service.ExpirableProduct;
import service.Shippable;

public class Biscuits extends ExpirableProduct implements Shippable {
    private double weight;

    public Biscuits(String name, double price, int availableQuantity, java.time.LocalDate expiryDate, double weight) {
        super(name, price, availableQuantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
