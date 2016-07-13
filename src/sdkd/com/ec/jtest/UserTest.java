package sdkd.com.ec.jtest;

import org.junit.Test;
import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/13.
 */
public class UserTest {
    BaseDao baseDao = new BaseDao();

    @Test
    public void userListTest(){
        EbUser user = null;
        String sql = "select * from easybuy_user where eu_user_name = ? and eu_password = ?";
        List<String> params = new ArrayList<String>();
        params.add("天天");
        params.add("tiantian");
        List<EbUser> userList = this.buildList(sql,params);
        if(userList!=null && userList.size()>0){
            user = userList.get(0);
            System.out.println(user);
        }
    }

    @Test
    public void userDetailTest(){
        System.out.println("userDetailTest");
    }





























    private List<EbUser> buildList(String sql, List<String> params){
        List<EbUser> userList = new ArrayList<EbUser>();
        ResultSet rs = baseDao.executeSearch(sql,params);
        try {
            while(rs.next()){
                EbUser user = new EbUser();
                user.setEuUserId(rs.getString("eu_user_id"));
                user.setEuUserName(rs.getString("eu_user_name"));
                user.setEuPassword(rs.getString("eu_password"));
                user.setEuSex(rs.getString("eu_sex"));
                user.setEuAddress(rs.getString("eu_address"));
                user.setEuBirthday(rs.getDate("eu_birthday"));
                user.setEuEmail(rs.getString("eu_email"));
                user.setIdentityCode(rs.getString("eu_identity_code"));
                user.setEuStatus(rs.getString("eu_status"));
                user.setEuMobile(rs.getString("eu_mobile"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
