package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SDUST-132 on 2016/7/11.
 */
public class EbLoginController extends HttpServlet {
    EbUserDao userDao = new EbUserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if("login".equals(action)){
            login(request, response);
        }else if("logout".equals(action)){
            logout(request, response);
        }

    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("userName");
        String pwd = request.getParameter("passWord");
        EbUser user = userDao.login(uname,pwd);
        request.getSession().setAttribute("currUser",user);
        response.sendRedirect("/index.do");
    }

    /**
     * 登出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EbUser user = (EbUser) request.getSession().getAttribute("currUser");
        if(user!=null){
            request.getSession().invalidate();
        }
        response.sendRedirect("/login.jsp");
    }
}
