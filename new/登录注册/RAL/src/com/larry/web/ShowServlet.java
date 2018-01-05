package com.larry.web;

import com.larry.dao.UserDao;
import com.larry.domain.Book;
import com.larry.domain.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");


        User user = (User) getServletContext().getAttribute("user");

        JSONObject jsonObject = JSONObject.fromObject(user);

        response.getWriter().write(jsonObject.toString());

//        List<Book> books = new UserDao().queryAllBook();
//
//        StringBuffer buffer = new StringBuffer();
//        for (Book book : books) {
//            buffer.append(book.toString());
//        }
//
//        JSONObject jsonObject = JSONObject.fromObject(buffer);
//        System.out.println(jsonObject.toString());
//        response.getWriter().write(jsonObject.toString());
    }
}
