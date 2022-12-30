package myCode;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "PostFormServlet", value = "/PostFormServlet")
public class PostFormServlet extends HttpServlet {

    private PreparedStatement preparedStatement;
    PrintWriter out;

    @Override
    public void init() throws ServletException{
        initializeJDBC();
    }




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        preparedStatement = conn.prepareStatement("insert into Book " + "(name, price, author) values (?, ?, ?)");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("author");
        System.out.println(name + " " + price + " " + author);
        storeBook(name, Integer.parseInt(price)  , author);
        out = response.getWriter();

        out.println("Book " + name + " has been stored in the database.");

        out.close();

    }

    private void storeBook(String name, int price, String author){
        try {
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,price);
            preparedStatement.setString(3,author);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void initializeJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading...");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/wilsonvideodb",
                    "wilson",
                    "password"
            );
            System.out.println("Database connected.");

//            preparedStatement = conn.prepareStatement("insert into Book " + "(name, price, author) values (?, ?, ?)");


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }



}
