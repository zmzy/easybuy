package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbPCategory;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 商品Controller
 * Created by SDUST-132 on 2016/7/8.
 */
public class EbProductController extends HttpServlet {
    EbProductDao productDao = new EbProductDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String action = request.getParameter("action");
        if(action != null && !"".equals(action)){
            if("list".equals(action)){

            }else if("detail".equals(action)){
                detail(request, response);
            }
        }

    }

    /**
     * 商品详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = 0;
        String paramsId = request.getParameter("id");
        if(paramsId != null && !"".equals(paramsId)){
            id = Integer.parseInt(paramsId);
        }
        EbProduct product = productDao.getProductById(id);
        request.setAttribute("product",product);
        //跳转页面
        request.getRequestDispatcher("/product-view.jsp").forward(request,response);
    }
}
