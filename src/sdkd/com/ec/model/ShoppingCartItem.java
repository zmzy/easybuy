package sdkd.com.ec.model;

/**
 * Created by SDUST-132 on 2016/7/8.
 */
public class ShoppingCartItem {
    private EbProduct product;  //商品对象
    private Long quantity;  //数量
    private Double cost;  //总金额

    public ShoppingCartItem(EbProduct product, long quantity) {
        this.product = product;
        this.quantity = quantity;
        this.cost = product.getEpPrice() * quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
        this.cost = product.getEpPrice() * quantity;
    }

    public EbProduct getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }
}
