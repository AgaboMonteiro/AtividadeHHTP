
package br.edu.ifsuldeminas.atividadehttp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headers") //Define a URL do Servlet
public class HeadersServlet extends HttpServlet { //Classe base para criar Servlets HTTP

    @Override
    protected void doGet(HttpServletRequest request, //doGet - Trata requisições GET | Request - Permite acessar dados da requisição
                         HttpServletResponse response) //HttpServletResponse - 	Permite construir a resposta 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        
        out.println("<style>");
        out.println(".cabecalho { color: red; }");
        out.println("</style>");

        out.println("<html>");
        out.println("<head><title>Analise HTTP</title></head>");
        out.println("<body>");

        out.println("<h1>Analise dos Cabecalhos HTTP</h1>");

        out.println("<h2>Informacoes da requisicao</h2>");

        out.println("<p class='cabecalho'><b>Endereco IP:</b> "
                + request.getRemoteAddr() + " (IP ::1 é equivalente ao 127.0.0.1 no IPv4)" +"</p>");//Recupera o endereço IP remoto

        out.println("<p class='cabecalho'><b>Versao HTTP:</b> "
                + request.getProtocol() + "</p>");//ecupera a versão do protocolo

        out.println("<h2>Cabecalhos recebidos</h2>");

        Enumeration<String> headers = request.getHeaderNames();//getHeaderNames - Recupera os nomes dos cabeçalhos

        while (headers.hasMoreElements()) {

            String nome = headers.nextElement();

            String valor = request.getHeader(nome);//getHeader(nome) - Recupera o valor de um cabeçalho
            
	            if(nome.equalsIgnoreCase("user-agent")) {
	                out.println("<p class='cabecalho'><b>" + "Navegador (" + nome + "):</b> "
	                        + valor + "</p>");
	            } else if(nome.equalsIgnoreCase("referer")) {
	                out.println("<p class='cabecalho'><b>" + "Página de origem (" + nome + "):</b> "
	                        + valor + "</p>");
	            } else if(nome.equalsIgnoreCase("accept-language")) {
	                out.println("<p class='cabecalho'><b>" + "Linguagem preferida (" + nome + "):</b> "
	                        + valor + "</p>");
	            } else if(nome.equalsIgnoreCase("accept-encoding")) {
	                out.println("<p class='cabecalho'><b>" + "Codificações aceitas (" + nome + "):</b> "
	                        + valor + "</p>");
	            }else out.println("<p><b>" + nome + ":</b> "
                    + valor + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
