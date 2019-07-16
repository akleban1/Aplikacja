package pl.sda.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import pl.sda.domain.Product;
import pl.sda.exception.ProductNotFoundException;
import pl.sda.service.ProductService;

public class ProductIdValidator implements ConstraintValidator<ProductId, String>{
	
	@Autowired
	private ProductService productService;

	public void initialize(ProductId constraintAnnotation) {
	}
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		try {
			product = productService.getProductById(value);
		} catch (ProductNotFoundException e) {
			return true;
		}
		if(product!= null) {
			return false;
		}
		return true;
	}
}
