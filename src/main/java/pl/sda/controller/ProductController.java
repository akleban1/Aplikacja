package pl.sda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.domain.repository.ProductRepository;

import java.math.BigDecimal;

@Controller
public class ProductController {
//    @RequestMapping("/products")
//    public String list(Model model) {
//        Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
//        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym wyświetlaczem o rozdzielczości 6401136 oraz 8-megapikselowym aparatem");
//                iphone.setCategory("Smart Phone");
//        iphone.setManufacturer("Apple");
//        iphone.setUnitsInStock(1000);
//        model.addAttribute("product", iphone);
//        return "products";
//    }
@Autowired
private ProductRepository productRepository;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products";
    }
}
