package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品数据访问层
 * Created by SDUST-132 on 2016/7/8.
 */
public class EbProductDao extends BaseDao {
    /**
     * 所有商品列表
     * @return
     */
    public List<EbProduct> getProductList(){
        List<EbProduct> productList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product";
        this.buildList(sql,null);
        return productList;
    }

    /**
     * 特价商品列表
     * @return
     */
    public List<EbProduct> getIsDiscountProduct(){
        String sql = "select * from easybuy_product where ep_discount = 1 limit 0,8";
        List<EbProduct> productList = this.buildList(sql,null);
        return productList;
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    public EbProduct getProductById(int id){
        EbProduct ebProduct = null;
        String sql = "select * from easybuy_product where ep_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(id+"");
        List<EbProduct> productList = this.buildList(sql,params);
        if(productList!=null && productList.size()>0){
            ebProduct = productList.get(0);
        }
        return ebProduct;
    }

    /**
     * 独立获取结果集
     * @param rs
     * @return
     */
    private List<EbProduct> buildList(String sql,List<String> params){
        List<EbProduct> productList = new ArrayList<EbProduct>();
        ResultSet rs = this.executeSearch(sql,params);
        try {
            while(rs.next()){
                EbProduct product = new EbProduct();
                product.setEpcId(rs.getInt("epc_id"));
                product.setEpcChildId(rs.getInt("epc_child_id"));
                product.setEpDescription(rs.getString("ep_description"));
                product.setEpDiscount(rs.getInt("ep_discount"));
                product.setEpFileName(rs.getString("ep_file_name"));
                product.setEpId(rs.getInt("ep_id"));
                product.setEpName(rs.getString("ep_name"));
                product.setEpPrice(rs.getDouble("ep_price"));
                product.setEpStock(rs.getInt("ep_stock"));
                product.setEpViews(rs.getInt("ep_views"));
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
