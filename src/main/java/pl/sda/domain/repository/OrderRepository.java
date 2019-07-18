package pl.sda.domain.repository;

import pl.sda.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
