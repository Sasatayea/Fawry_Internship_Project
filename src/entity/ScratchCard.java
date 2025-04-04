package entity;

import service.NonExpirableProduct;

public class ScratchCard extends NonExpirableProduct {

    public ScratchCard(String name, double price, int availableQuantity) {
        super(name, price, availableQuantity);
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }

}
