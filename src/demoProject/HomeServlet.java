package demoProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static List<User> userList = new ArrayList<User>();
       
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
	
		String method = request.getParameter("mode");
		
		try {
			if(method.equalsIgnoreCase("saveData")){
				saveData(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private void saveData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Came here to get the data");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		System.out.println("My Details are: "+firstName+" : "+lastName+" : "+email+" : "+gender);
		
		User user = new User(firstName, lastName, email, gender);
		userList.add(user);
		
		request.setAttribute("userData", userList);
	    RequestDispatcher rd = getServletContext()
	                               .getRequestDispatcher("/Details.jsp");
	    rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

