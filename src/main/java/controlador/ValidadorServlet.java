package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidadorServlet", urlPatterns = {"/ValidadorServlet"})
public class ValidadorServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet ValidatorServlet</title> ");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet ValidatorServlet at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    
	    String usuario, password, msg;
	    // recivir parametros
	    usuario = request.getParameter("usuario");
	    password = request.getParameter("password");
	    // validar
	    if (usuario.equals("admin") && password.equals("admin")) {
	    	msg = "Usuario y contraseña correcta";
	    }else {
	    	msg = "Revise su usuario y contraseña";
	    }
	    //ejecuta logica de negocio
	    msg = msg.toUpperCase();
	    //seleccionar proxima vista
	    RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
	    //prepara los datos para vista seleccionada 
	    request.setAttribute("mensaje", msg);
	    //despachar
	    despachador.forward(request, response);
	}
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}
	
}
