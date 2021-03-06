package com.atsistemas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Controlador
 */
@WebServlet({ "/Alta", "/Baja", "/Afines" })
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controlador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//Forma fea de acceder al contexto de spring desde el ServletContext
		//ApplicationContext context = (ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		//Forma elegante de acceder al contexto de spring
		WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(getServletContext());
		
		Servicio servicio = context.getBean(Servicio.class);
		
		String resultado = servicio.metodo();
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(resultado);
		
	}

}
