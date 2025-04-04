import entity.*;
import service.*;

public class Main {
    public static void main(String[] args) {

        // Create products
        Cheese cheese = new Cheese("Cheddar Cheese", 100, 10, java.time.LocalDate.now().plusDays(30), 0.4);
        Biscuits biscuits = new Biscuits("Chocolate Biscuits", 150, 20, java.time.LocalDate.now().plusDays(90), 0.7);
        TV tv = new TV("55-inch Smart TV", 5000, 5, 25.0);
        Mobile mobile = new Mobile("Smartphone X", 1200, 15, 0.3);
        ScratchCard scratchCard = new ScratchCard("100$ Scratch Card", 120, 50);

        // Create customer
        Customer customer = new Customer("John Doe", 1000000);

        // Create cart and services
        ShoppingCart cart = new ShoppingCart();
        ShippingService shippingService = new DefaultShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        // Example 1: Successful checkout with mixed products
        try {
            cart.add(cheese, 2);
            cart.add(tv, 3);
            cart.add(scratchCard, 1);
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

//        // Example 2: Error - product out of stock
//        try {
//            cart.add(tv, 10); // Only 4 left after first checkout
//            checkoutService.checkout(customer, cart);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        // Example 3: Error - insufficient balance
//        try {
//            Customer poorCustomer = new Customer("Poor Guy", 100);
//            cart.add(tv, 1);
//            checkoutService.checkout(poorCustomer, cart);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        // Example 4: Error - empty cart
//        try {
//            ShoppingCart emptyCart = new ShoppingCart();
//            checkoutService.checkout(customer, emptyCart);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        // Example 5: Error - expired product
//        try {
//            Cheese expiredCheese = new Cheese("Expired Cheese", 50, 5, java.time.LocalDate.now().minusDays(1), 0.4);
//            cart.add(expiredCheese, 1);
//            checkoutService.checkout(customer, cart);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }

    }
}