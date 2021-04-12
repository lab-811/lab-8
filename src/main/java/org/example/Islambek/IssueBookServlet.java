package org.example.Islambek;

import org.example.Islambek.config.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long bookId = Long.valueOf(request.getParameter("bookId"));
        String userId = null;

        Connection connection = JDBCUtils.getConnection();

        Cookie ck[] = request.getCookies();

        if(ck != null){
            int  i = 0;
            while (!ck[i].getName().equals("userId")) {
                i++;
            }

             userId = ck[i].getValue();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO IssuedBooks(book_id, user_id) VALUES (?,?)");

            preparedStatement.setLong(1, bookId);
            preparedStatement.setLong(2, Long.parseLong(userId));

            preparedStatement.executeUpdate();

            String message;

            {
                message = "The Book has been successfully Issued";
            }

            request.setAttribute("message", message);
            request.getRequestDispatcher("issueBook.jsp").include(request,response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
