
package br.edu.ifsuldeminas.atividadehttp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies(); //request.getCookies()	Recupera os cookies enviados pelo navegador

        boolean usuarioEncontrado = false;

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("usuario")) { //cookie.getName()	Recupera o nome do cookie

                    out.println("<h1>Bem-vindo de volta, usuario "
                            + cookie.getValue() + "</h1>");//cookie.getValue()	Recupera seu valor

                    usuarioEncontrado = true;
                    break;
                }
            }
        }

        if (!usuarioEncontrado) {

            Cookie cookie = new Cookie("usuario", "X"); //new Cookie()	Cria um novo cookie

            cookie.setMaxAge(60 * 60 * 24 * 7);//cookie.setMaxAge()	Define validade

            cookie.setPath("/");

            response.addCookie(cookie);//response.addCookie()	Envia o cookie ao navegador

            out.println("<h1>Primeira visita!</h1>");
            out.println("<p>Cookie criado para o usuario X.</p>");
        }
    }
}
