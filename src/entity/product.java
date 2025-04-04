package entity;

public abstract class product {

    private String name;
    private double price;
    private int availableQuantity;

    public product(String name, double price, int availableQuantity) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void reduceQuantity(int quantity) {
        if (quantity > availableQuantity) {
            throw new IllegalArgumentException("Not enough quantity available");
        }
        availableQuantity -= quantity;
    }

    public abstract boolean isExpired();
    public abstract boolean requiresShipping();

}
