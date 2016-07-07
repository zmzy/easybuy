package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbPCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品类型
 * Created by SDUST-132 on 2016/7/7.
 */
public class EbPCategoryDao extends BaseDao {
    public List<EbPCategory> getCategories() {
        List<EbPCategory> list = new ArrayList<EbPCategory>();
        String sql = "select * from easybuy_product_category";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while(rs.next()){
                EbPCategory category = new EbPCategory();
                category.setEpcId(rs.getInt("epc_id"));
                category.setEpcname(rs.getString("epc_name"));
                category.setEpcParentId(rs.getInt("epc_parent_id"));

                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
