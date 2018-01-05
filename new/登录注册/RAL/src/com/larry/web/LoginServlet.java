package com.larry.web;

import com.larry.dao.UserDao;
import com.larry.domain.Book;
import com.larry.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
            User u = userDao.queryByUsername(user.getUsername());

            if (user.getUsername().equals(u.getUsername())){
                if (user.getPassword().equals(u.getPassword())){
                    //表示登录成功
                    getServletContext().setAttribute("user",user);

//                    获得书信息
                    List<Book> books = new UserDao().queryAllBook();
//                    请求时用会话对象封装
                    request.getSession().setAttribute("books",books);
                    request.getSession().setAttribute("user",user);

//                    请求转发，带上信息。
                    request.getRequestDispatcher("/index.jsp").forward(request,response);

//                    设置用户名
                    getServletContext().setAttribute("userName",user.getUsername());

                    return;
                }else {
                    System.out.println("密码错误");
                }
            }else {
                System.out.println("无用户名");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
