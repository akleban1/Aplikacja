package pl.sda.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CartItem implements Serializable {
    private static final long serialVersionUID = -4314427089896169685L;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getUnitPrice();
    }
    public void setProduct(Product product) {
        this.product = product;
        this.updateTotalPrice();
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public void updateTotalPrice() {
        totalPrice = this.product.getUnitPrice().multiply(new
                BigDecimal(this.quantity));
    }
    @Override
    public int hashCode() {
        final int prime = 311;
        int result = 1;
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartItem other = (CartItem) obj;
        if (product == null) {
            if (other.product != null){
                return false;
            }
        } else if (!product.equals(other.product)){
            return false;
        }
        return true;
    }
}
