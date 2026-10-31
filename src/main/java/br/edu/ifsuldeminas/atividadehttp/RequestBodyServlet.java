
package br.edu.ifsuldeminas.atividadehttp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request-body")
public class RequestBodyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<h1>Corpo da requisicao POST</h1>");

        out.println("<h2>Dados recebidos:</h2>");

        BufferedReader reader = request.getReader();//request.getReader(): permite ler o corpo inteiro da requisição.

        String linha;

        while ((linha = reader.readLine()) != null) {

            out.println("<p>" + linha + "</p>");

        }
    }
}
