package pl.sda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.domain.Product;
import pl.sda.domain.repository.ProductRepository;
import pl.sda.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public void processOrder(String productId, int count) {

    }

    @Autowired
    private ProductRepository productRepository;

    public void processOrder(String productId, long quantity) {
        Product productById = productRepository.getProductById(productId);

        if(productById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie "+ productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
    }

}




