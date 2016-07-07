package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户DAO
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUserDao extends BaseDao {
    /**
     * 保存用户
     */
    public void saveUser(EbUser user){
        String sql = "insert into easybuy_user(eu_user_id,eu_user_name,eu_password,eu_sex) values(?,?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(user.getEuUserId());
        params.add(user.getEuUserName());
        params.add(user.getEuPassword());
        params.add(user.getEuSex());
        this.executeModify(sql,params);
    }

    public EbUser findByUser(String username,String password){
        EbUser user = null;
        String sql = "select * from easybuy_user where eu_user_name=? and eu_user_password=?";
        List<String> params = new ArrayList<String>();
        params.add(username);
        params.add(password);
        ResultSet rs = this.executeSearch(sql,params);
        try {
            if (rs.next()){
                user = new EbUser();
                user.setEuAddress(rs.getString("eu_address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void testDelete(){
        //JDBC的步骤
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.桥梁--Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.210.228:3306/easybuy","root","root");
            //3.CRUD
            String sql = "delete from easybuy_user where eu_user_id = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            int result = ps.executeUpdate();
            System.out.println(result);
            //sout+Tab
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testQuery(){
        //JDBC的步骤
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.桥梁--Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.210.210:3306/easybuy","root","root");
            //3.CRUD
            String sql = "select * from easybuy_user";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("eu_user_name");
                System.out.println("name："+name);
            }
            //sout+Tab
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        test();
//        testUpdate();
//        testDelete();
        testQuery();
    }
}
