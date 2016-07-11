package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbPCategory;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
                list(request, response);
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
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pageIndexParam = request.getParameter("pageIndex");
        String pageSizeParam = request.getParameter("pageSize");
        int pageIndex  = 1;
        int pageSize = 4;
        if(pageIndexParam!=null && !"".equals(pageIndexParam)){
            pageIndex = Integer.parseInt(pageIndexParam);
        }
        if(pageSizeParam!=null && !"".equals(pageSizeParam)){
            pageSize = Integer.valueOf(pageSizeParam);
        }
        List<EbProduct> productList = productDao.getProductPager(pageIndex,pageSize);
        int count = productDao.getProductCount();
        int totalPage  = count % pageSize == 0 ?(count/pageSize):((count/pageSize)+1);

        request.setAttribute("productList",productList);
        request.setAttribute("totalPage",totalPage);  //总记录数

        //跳转页面
        request.getRequestDispatcher("/product-list.jsp").forward(request,response);
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
