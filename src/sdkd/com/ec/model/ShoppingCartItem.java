package sdkd.com.ec.model;

/**
 * Created by SDUST-132 on 2016/7/8.
 */
public class ShoppingCartItem {
    private EbProduct product;  //商品对象
    private long quantity;  //数量
    private double cost;  //总金额

    public ShoppingCartItem(EbProduct product, long quantity) {
        this.product = product;
        this.quantity = quantity;
        this.cost = product.getEpPrice() * quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
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
