package service;

import entity.product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> items = new ArrayList<>();

    public void add(product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (quantity > product.getAvailableQuantity()) {
            throw new IllegalArgumentException("Not enough quantity available for " + product.getName());
        }

        // Check if product already exists in cart
        for (CartItem item : items) {
            if (item.getProduct() == product) {
                // If total quantity exceeds available, throw exception
                if (item.getQuantity() + quantity > product.getAvailableQuantity()) {
                    throw new IllegalArgumentException("Not enough quantity available for " + product.getName());
                }
                // Add to existing item
                items.remove(item);
                items.add(new CartItem(product, item.getQuantity() + quantity));
                return;
            }
        }

        // Add new item
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
