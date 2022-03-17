package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(AddCategoryServlet.URL)
public class AddCategoryServlet extends HttpServlet {
    public final static String URL = "/auth/add-category";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addCategory.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("CName");

        try {
            Category category = new Category(categoryName);
            CategoryDao categoryDao = DaoFactory.getJpaCategoryDao();
            Long id = categoryDao.add(category);
            resp.sendRedirect(ShowCategoryServlet.URL + "?id=" + id);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
