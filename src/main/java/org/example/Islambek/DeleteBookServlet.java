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


public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Long id = Long.valueOf(request.getParameter("bookId"));

        Connection connection = JDBCUtils.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Books WHERE id=?");

            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();

            String message;

            {
                message = "The Book has been successfully deleted";
            }

            request.setAttribute("message", message);
            request.getRequestDispatcher("deleteBook.jsp").include(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
