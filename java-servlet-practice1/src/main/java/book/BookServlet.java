package book;

import Obj.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private PreparedStatement preparedStatement;



    @Override
    public void init() throws ServletException{
        initializeJDBC();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        try {
            preparedStatement.setString(1,request.getParameter("name"));
            ResultSet rs = preparedStatement.executeQuery();
            Book book = null;
            if(rs.next()){
                book = new Book();
                book.setName(rs.getString("name"));
                book.setPrice(rs.getInt("price"));
                book.setAuthor(rs.getString("author"));

            }
            request.setAttribute("book", book);
            request.getRequestDispatcher("/book.jsp").forward(request, response);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//        String name = request.getParameter("name");
//        String price = request.getParameter("price");
//        String author = request.getParameter("author");
//
//        Book book = new Book();
//        book.setName(name);
//        book.setPrice(Integer.parseInt(price));
//        book.setAuthor(author);
//
//        HttpSession httpSession = request.getSession();
//        httpSession.setAttribute("book",book);





//        PrintWriter out = response.getWriter();
//        out.println("You entered the following data:");
//        out.println("<p>Book name: "+ name+ " </p> ");
//        out.println("<br />");
//        out.println("<p>Book price: "+ price + " </p> ");
//        out.println("<br />");
//        out.println("<p>Book author: "+ author + " </p> ");
//        out.println("<br />");
//        out.println("<form method=\"post\" action=\"/sessionRegis\">");
//        out.println("<input type =\"submit\" value=\"submit\" >");
//        out.println("</form>");
//        out.close();




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        Book book = (Book) httpSession.getAttribute("book");


        try{
//            storeBook( book.getName() ,book.getPrice()  , book.getAuthor());
//
//            PrintWriter out = response.getWriter();
//
//            out.println("Book " + book.getName() + " has been stored in the database.");
//
//            out.close();
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

            preparedStatement = conn.prepareStatement("select * from book where name = ?");


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
