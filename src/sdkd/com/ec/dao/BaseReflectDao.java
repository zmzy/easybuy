package sdkd.com.ec.dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by SDUST-132 on 2016/7/11.
 */
public class BaseReflectDao<T> {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        try {
            //1.加载驱动
            Class.forName(getPro("driver"));
            //2.桥梁--Connection
            con = DriverManager.getConnection(getPro("url"),getPro("username"),getPro("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 释放资源
     */
    public void close(){
        try {
            if(rs!=null) rs.close();
            if(ps != null) ps.close();
            if(con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取配置信息
     * @return
     */
    public String getPro(String key){
        Properties pro = new Properties();
        try {
            InputStream is =this.getClass().getResourceAsStream("/jdbc.properties");
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = pro.get(key).toString();
        return value;
    }

    /*public List<T> getList(Object clz,String sql,List<Object> params){
        List<Object> list = new ArrayList<>();
        Class c = clz.getClass();
        try {
            con = this.getConnection();
            ps = con.prepareStatement(sql);
            if(params!=null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    Object obj = params.get(i);
                    if(obj.getClass().getName().equals("java.lang.String")){
                        ps.setString((i+1),obj.toString());
                    } else if(obj.getClass().getName().equals("java.lang.Integer")){
                        ps.setInt((i+1),Integer.parseInt(obj.toString()));
                    }
                }
            }
            rs = ps.executeQuery();
            Class type = null;
            while (rs.next()){
                clz = c.newInstance();
                List<String> keys = this.getRsKey(c);
                Method method = null;
                for(int i=0;i<list.size();i++){
                    String key = keys.get(i);
                    String mname =  this.getMethodName(key);  //组装set方法
                    String typeName = c.getDeclaredField(key).getType().getName();
                    if("int".equals(typeName)){
                        type = int.class;
                        method = c.getMethod(mname,type);
                        method.invoke(clz,rs.getInt(key));
                    }else if("java.lang.String".equals(typeName)){
                        type = String.class;
                        method = c.getMethod(mname,type);
                        method.invoke(clz,rs.getString(key));
                    }
                }
                list.add(clz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (List<T>)list;
    }*/

    /*public List<String> getRsKey(Class<?> clz){
        List<String> list = new ArrayList<>();
        Field[] fs = clz.getDeclaredFields();
        for(Field f : fs){
            list.add(f.getName());
        }
        return list;
    }

    public String getMethodName(String key){
        return "set"+key.substring(0,1).toUpperCase()+key.toLowerCase().substring(1);
    }*/
}
