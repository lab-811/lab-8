package org.example.Islambek;

import org.example.Islambek.config.JDBCUtils;
import org.example.Islambek.model.Issued;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ViewIssuedBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            List<Issued> issueds = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM IssuedBooks WHERE user_id=?");

            preparedStatement.setLong(1, Long.parseLong(userId));

           ResultSet resultSet =  preparedStatement.executeQuery();

           while (resultSet.next()){
               Issued issued = new Issued();

               issued.setId(resultSet.getLong("id"));
               issued.setBook_id(resultSet.getLong("book_id"));

               issueds.add(issued);

           }


           request.setAttribute("Issueds", issueds);
           request.getRequestDispatcher("viewIssuedBooks.jsp").include(request,response);




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
