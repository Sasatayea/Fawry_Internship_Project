package service;

import entity.product;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    private static final double SHIPPING_COST_PER_KG = 30.0;
    private ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, ShoppingCart cart) {
        // Check if cart is empty
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cannot checkout with empty cart");
        }

        // Check for expired products and calculate totals
        double subtotal = 0;
        List<Shippable> itemsToShip = new ArrayList<>();
        double totalShippingWeight = 0;

        for (CartItem item : cart.getItems()) {
            product product = item.getProduct();

            // Check if product is expired
            if (product.isExpired()) {
                throw new IllegalStateException("Product " + product.getName() + " is expired");
            }

            // Check if product is in stock
            if (item.getQuantity() > product.getAvailableQuantity()) {
                throw new IllegalStateException("Product " + product.getName() + " is out of stock");
            }

            // Add to subtotal
            subtotal += item.getTotalPrice();

            // Add to shipping if required
            if (product.requiresShipping() && product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                for (int i = 0; i < item.getQuantity(); i++) {
                    itemsToShip.add(shippable);
                    totalShippingWeight += shippable.getWeight();
                }
            }
        }

        // Calculate shipping cost
        double shippingCost = totalShippingWeight * SHIPPING_COST_PER_KG;
        double totalAmount = subtotal + shippingCost;

        // Check if customer has enough balance
        if (customer.getBalance() < totalAmount) {
            throw new IllegalStateException("Insufficient balance to complete checkout");
        }

        // Process payment and reduce product quantities
        customer.reduceBalance(totalAmount);
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Ship products if needed
        if (!itemsToShip.isEmpty()) {
            shippingService.ship(itemsToShip);
        }

        // Print receipt
        System.out.println("");
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingCost);
        System.out.println("Amount " + totalAmount);
//        System.out.println("Remaining balance " + customer.getBalance());

        // Clear cart after successful checkout
        cart.clear();
    }
}
