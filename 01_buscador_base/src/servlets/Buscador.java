package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import service.BuscadorService;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
			
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String tema=request.getParameter("tema");
		BuscadorService service=new BuscadorService();
		List<Item> items=service.buscarItems(tema);
		if(items!=null) {
			//recorremos todos los item de la lista
			for(var item:items) {
				out.println("<h2><a href='"+item.getUrl()+"'>"+item.getTitulo()+"</a><br/>");
			}
			out.println("</body></html>");
		}
		else {
			//transferimos el control a otro servlet 
			//encargado de generar una página de error
			RequestDispatcher dispatcher=request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
	}
	

}
