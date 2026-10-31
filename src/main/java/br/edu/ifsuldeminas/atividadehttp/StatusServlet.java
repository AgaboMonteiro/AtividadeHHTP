
package br.edu.ifsuldeminas.atividadehttp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("code");

        if (codigo == null) {
            response.sendError(400, "Parametro code obrigatorio");
            return;
        }

        switch (codigo) {

            case "200":

                response.setStatus(HttpServletResponse.SC_OK); //define o código HTTP que será enviado na resposta.
                response.setContentType("text/html;charset=UTF-8");

                PrintWriter out = response.getWriter();

                out.println("<h1>200 - OK</h1>");
                out.println("<p>Requisicao realizada com sucesso!</p>");

                break;

            case "404":

                response.sendError( //Envia uma resposta de erro com o código indicado, podendo apresentar a página de erro padrão do Tomcat.
                    HttpServletResponse.SC_NOT_FOUND,
                    "Pagina nao encontrada"
                );

                break;

            case "500":

                response.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Erro interno do servidor"
                );

                break;

            default:

                response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Codigo nao suportado"
                );

                break;
        }
    }
}
