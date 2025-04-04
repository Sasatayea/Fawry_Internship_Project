package entity;

import service.NonExpirableProduct;
import service.Shippable;

public class Mobile extends NonExpirableProduct implements Shippable {

    private double weight;

    public Mobile(String name, double price, int availableQuantity, double weight) {
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
