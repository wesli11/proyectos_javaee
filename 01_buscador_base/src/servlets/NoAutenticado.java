package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoAutenticado
 */
@WebServlet("/NoAutenticado")
public class NoAutenticado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		//los parámetros que le llegaron al servlet de origen
		//están disponibles también en el destino
		String user=request.getParameter("usuario");
		out.println("<h2>El usuario "+user+" no está autenticado</h2>");
		out.println("<a href='login.html'>Volver</a>");
		out.println("</body></html>");
	}

}
