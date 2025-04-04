package service;

import java.util.List;

public interface ShippingService {
    void ship(List<Shippable> items);
}
