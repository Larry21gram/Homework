package com.larry.web;

import com.larry.dao.UserDao;
import com.larry.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegistServlet",urlPatterns = "/register")
public class RegistServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();

        try {
            BeanUtils.populate(user,parameterMap);
            System.out.println(user);
            String formName = user.getUsername();
            User fromDb = userDao.queryByUsername(formName);

            if (fromDb != null){
//                已经被注册
                response.sendRedirect("/register.html");
                return;
            }else {
                userDao.insert(user);
                response.sendRedirect("/login.html");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
