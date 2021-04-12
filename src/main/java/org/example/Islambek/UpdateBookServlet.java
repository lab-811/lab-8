package org.example.Islambek;

import org.example.Islambek.config.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Long bookId = Long.valueOf(request.getParameter("bookId"));
            String title =  request.getParameter("title");
            String author = request.getParameter("author");

        Connection connection = JDBCUtils.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Books SET title=?, author=? WHERE  id=?");

        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setLong(3, bookId);

        preparedStatement.executeUpdate();

        String message;

            {
             message = "The book has been successfully updated";
            }

            request.setAttribute("message", message);
            request.getRequestDispatcher("updateBook.jsp").include(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
