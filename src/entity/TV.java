package entity;

import service.NonExpirableProduct;
import service.Shippable;

public class TV extends NonExpirableProduct implements Shippable {

    private double weight;

    public TV(String name, double price, int availableQuantity, double weight) {
        super(name, price, availableQuantity);
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
