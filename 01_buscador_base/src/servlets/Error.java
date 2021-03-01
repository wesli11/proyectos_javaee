package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Error
 */
@WebServlet("/Error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		//los parámetros que le llegaron al servlet de origen
		//están disponibles también en el destino
		String tema=request.getParameter("tema");
		out.println("<h2>No hay entradas para el tema "+tema+"</h2>");
		out.println("<a href='buscador.html'>Volver</a>");
		out.println("</body></html>");
	}

}
