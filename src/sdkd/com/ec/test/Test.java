package sdkd.com.ec.test;

import sdkd.com.ec.dao.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/11.
 */
public class Test {
    public static void main(String[] args) {
        BaseDao b = new BaseDao();
        String sql = "select * from easybuy_product limit ?,?";
        List<Object> params = new ArrayList<>();
        params.add(0);
        params.add(4);
        b.myExecuteSearch(sql,params);
    }
}
