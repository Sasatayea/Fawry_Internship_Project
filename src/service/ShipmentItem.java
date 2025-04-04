package service;

public class ShipmentItem {

    private Shippable item;
    private int quantity;

    public ShipmentItem(Shippable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Shippable getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
}
