package loginform;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * Servlet implementation class validante
 */
@WebServlet("/validante")
public class Validante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.getWriter().append("Acceso denegado").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        System.out.println(request.getParameter("nombre"));
        System.out.println(request.getParameter("clave"));
        System.out.println("Dios esta ahi");
        Manejadordb c= new Manejadordb();
        ManejadorMD5 md5 = new ManejadorMD5();
        
        Connection sqlserver;
		try {
			sqlserver = c.conector("aawyxtumwg8ep9.ca3ssjbhvj3h.us-west-2.rds.amazonaws.com", 5432, "db_credenciales", "java_user", "12345678");
		//Statement test=sqlserver.createStatement();
		//ResultSet r= test.executeQuery("SELECT COUNT(*) AS total FROM [dbo].[credenciales] where Nombre='"+request.getParameter("nombre")+"' and clave='"+ md5.encriptaClave(request.getParameter("clave"))+"'");
		String sqlvalidaUser="SELECT COUNT(*) AS total FROM credenciales where Nombre=? and clave=?";
		PreparedStatement p=sqlserver.prepareStatement(sqlvalidaUser);
		p.setString(1, request.getParameter("nombre"));
		p.setString(2, md5.encriptaClave(request.getParameter("clave")));
		ResultSet r=p.executeQuery();
		r.next();
		int autentiacion=r.getInt(1);
		if (autentiacion==1) {
			response.sendRedirect("AccesoConcedido.jsp");  
			System.out.println("inicio de sesion correcto.");
			System.out.println(md5.encriptaClave(request.getParameter("clave")));
			
		} else {
			System.out.println("fallaste!!!"+" "+md5.encriptaClave(request.getParameter("clave")));
			request.setAttribute("estado", "fallaste, aqui estoy de nuevo");
			
		      RequestDispatcher tp;
		    tp=request.getRequestDispatcher("index.jsp");
		    tp.forward(request, response);
		} 
		

	
		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}

}
