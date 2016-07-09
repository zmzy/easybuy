package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.ShoppingCart;
import sdkd.com.ec.model.ShoppingCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/8.
 */
public class EbShoppingController extends HttpServlet {
    EbProductDao productDao = new EbProductDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean issame =false;
        //1.获取商品ID
        String paramsId = request.getParameter("id");
        int id = 0;
        if(paramsId != null && !"".equals(paramsId)){
            id = Integer.parseInt(paramsId);
        }
        EbProduct product = productDao.getProductById(id);
        //2.存储至session

        //存session之前判断是否已经存在
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new ShoppingCart();
            cart.addItem(product,1);
        }else{
            //如果存在，查找有无相同的商品，如果有则更新数量
            List<ShoppingCartItem> items = cart.getItems();
            if(items!=null && items.size()>0){
                for(ShoppingCartItem item : items){
                    EbProduct itemPro = item.getProduct();
                    if(itemPro.getEpId()==id){
                        item.setQuantity(item.getQuantity()+1);
                        issame = true;  //标识
                    }
                }
            }
            //若不存在，则直接添加，数量默认为1
            if(!issame) {
                cart.addItem(product, 1);
            }
        }
        request.getSession().setAttribute("cart",cart);
        request.getRequestDispatcher("/shopping.jsp").forward(request,response);
    }

    /**
     * 点击购买添加至购物车
     */
    public void addCart(){

    }

    /**
     * 购物车页面进行修改
     */
    public void modifyCart(){

    }
}
