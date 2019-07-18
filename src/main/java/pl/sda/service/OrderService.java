package pl.sda.service;

import pl.sda.domain.Order;

public interface OrderService {
    void processOrder(String productId, long quantity);
    Long saveOrder(Order order);
}
