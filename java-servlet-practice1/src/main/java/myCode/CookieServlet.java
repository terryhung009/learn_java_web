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

@WebServlet(name = "CookieServlet", value = "/CookieServlet")
public class CookieServlet extends HttpServlet {

    private PreparedStatement preparedStatement;



    @Override
    public void init() throws ServletException{
        initializeJDBC();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("author");

        Cookie cookieName = new Cookie("name",name);
        Cookie cookiePrice = new Cookie("price",price);
        Cookie cookieAuthor = new Cookie("author",author);
        response.addCookie(cookieName);
        response.addCookie(cookiePrice);
        response.addCookie(cookieAuthor);

        PrintWriter out = response.getWriter();
        out.println("You entered the following data:");
        out.println("<p>Book name: "+ name+ " </p> ");
        out.println("<br />");
        out.println("<p>Book price: "+ price + " </p> ");
        out.println("<br />");
        out.println("<p>Book author: "+ author + " </p> ");
        out.println("<br />");
        out.println("<form method=\"post\" action=\"/cookieRegis\">");
        out.println("<input type =\"submit\" value=\"submit\" >");
        out.println("</form>");
        out.close();




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name="";
        int price=0;
        String author="";

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("name")){
                name = cookie.getValue();
            }
            if(cookie.getName().equals("price")){
                price = Integer.parseInt(cookie.getValue());
            }
            if(cookie.getName().equals("author")){
                author = cookie.getValue();
            }
        }

        try{
            storeBook( name , price  , author);

            PrintWriter out = response.getWriter();

            out.println("Book " + name + " has been stored in the database.");

            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }





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

            preparedStatement = conn.prepareStatement("insert into Book " + "(name, price, author) values (?, ?, ?)");


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
