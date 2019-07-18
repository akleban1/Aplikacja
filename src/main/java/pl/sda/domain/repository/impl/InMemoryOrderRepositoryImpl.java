package pl.sda.domain.repository.impl;

import org.springframework.stereotype.Repository;
import pl.sda.domain.Order;
import pl.sda.domain.repository.OrderRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {
    @Override
    public Long saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }
    private Map<Long, Order> listOfOrders;
    private long nextOrderId;
    public InMemoryOrderRepositoryImpl() {
        listOfOrders = new HashMap<Long, Order>();
        nextOrderId = 1000;
    }
    private synchronized long getNextOrderId() {
        return nextOrderId++;
    }
}
