
package br.edu.ifsuldeminas.atividadehttp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/methods")
public class MethodsServlet extends HttpServlet {

    @Override
    protected void doOptions(HttpServletRequest request,
                             HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("Allow", "GET, POST, OPTIONS");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Metodos HTTP</title></head>");
        out.println("<body>");

        out.println("<h1>Metodos HTTP suportados</h1>");

        out.println("<ul>");
        out.println("<li>GET</li>");
        out.println("<li>POST</li>");
        out.println("<li>OPTIONS</li>");
        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");
    }
}
