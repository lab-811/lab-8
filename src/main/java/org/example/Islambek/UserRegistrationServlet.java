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


public class UserRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Connection connection = JDBCUtils.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users( name, password)  VALUES (?,?)");
                   preparedStatement.setString(1, name);
                   preparedStatement.setString(2, password);
                   preparedStatement.executeUpdate();

                   request.getRequestDispatcher("userLogin.jsp").include(request, response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
