package pl.sda.domain.repository;

import pl.sda.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
}
