package sdkd.com.ec.model;

import java.util.List;

/**
 * 购物车
 * Created by SDUST-132 on 2016/7/8.
 */
public class ShoppingCart {
    private List<ShoppingCartItem> items;
    public void addItem(EbProduct product, long quantity) {
        items.add(new ShoppingCartItem(product, quantity));
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public void modifyQuantity(int index, long quantity) {
        items.get(index).setQuantity(quantity);
    }

    public double getTotalCost() {
        double sum = 0;
        for (ShoppingCartItem item : items) {
            sum = sum + item.getCost();
        }
        return sum;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }
}
