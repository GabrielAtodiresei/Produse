package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello") //in adnotare vom defini URL-ul
public class HelloWorldServlet extends HttpServlet {

    private String name;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = new PrintWriter(response.getWriter());
        out.println("<html><head><title> Hello world </title></head>");
        out.println("<body> Hello world at " + new Date());
        out.println("</body>></html>");
        out.close();
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        this.name = name;
      /*  PrintWriter out = new PrintWriter(response.getWriter());
        out.println("<html><head><title> Hello world </title></head>");
        out.println("<body>  HELLO" + name + new Date()+ "</body></html>");*/

      request.setAttribute("name", name + "portocala");
      request.getRequestDispatcher("/result.jsp").forward(request, response);/*se pune forward pt. ca
                * datele mele din urma sa nu fie uitate*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
