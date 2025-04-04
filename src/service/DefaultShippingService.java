package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultShippingService implements ShippingService {
    @Override
    public void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        // Group items by name and count quantities
        Map<String, ShipmentItem> shipmentItems = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            totalWeight += item.getWeight();

            if (shipmentItems.containsKey(name)) {
                shipmentItems.get(name).incrementQuantity();
            } else {
                shipmentItems.put(name, new ShipmentItem(item, 1));
            }
        }

        // Print shipment items in the requested format
        for (ShipmentItem shipmentItem : shipmentItems.values()) {
            Shippable item = shipmentItem.getItem();
            int quantity = shipmentItem.getQuantity();
            System.out.println(quantity + "x " + item.getName() + " " + (int)(item.getWeight() * 1000) + "g");
        }

        System.out.print("Total package weight " + String.format("%.1f", totalWeight) + "kg");
        System.out.println();
    }
}
