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
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Connection connection = JDBCUtils.getConnection();

        String adminName = null;
        String adminPassword = null;
        Long adminId = null;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Admin WHERE name=? and password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                adminId = resultSet.getLong("id");
                adminName = resultSet.getString("name");
                adminPassword = resultSet.getString("password");
            }

            if(name.equals(adminName) && password.equals(adminPassword)){

                request.getRequestDispatcher("adminDashboard.jsp").include(request,response);
            }else {
                request.getRequestDispatcher("adminLogin.jsp").include(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
