package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final String user="admin";
	private static final String pass="admin";
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		RequestDispatcher dispatcher;
		if(usuario.equals(user)&&password.equals(pass)) {
			dispatcher=request.getRequestDispatcher("buscador.html");
		}
		else {
			dispatcher=request.getRequestDispatcher("NoAutenticado");
		}
		dispatcher.forward(request, response);
	}

}
