package org.example.Islambek;

import org.example.Islambek.config.JDBCUtils;
import org.example.Islambek.model.Book;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewBookServlet")
public class ViewBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = new ArrayList<>();
        Connection connection = JDBCUtils.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Books ORDER BY id");

            ResultSet resultSet = preparedStatement.executeQuery();

           while (resultSet.next()){
               Book book = new Book();

               book.setId(resultSet.getLong("id"));
               book.setTitle(resultSet.getString("title"));
               book.setAuthor(resultSet.getString("author"));

               books.add(book);
           }

           request.setAttribute("Books", books);
           request.getRequestDispatcher("viewBooks.jsp").include(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
