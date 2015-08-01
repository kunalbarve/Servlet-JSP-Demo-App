package demoProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			}else if(method.equalsIgnoreCase("deleteData")){
				deleteUser(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String userId = request.getParameter("id");
		List<User> newList = new ArrayList<User>();
		
		for (User user : userList) {
			if(!user.getId().equalsIgnoreCase(userId)){
				newList.add(user);
			}
		}
		
		userList = newList;
		request.setAttribute("userData", userList);
	    RequestDispatcher rd = getServletContext()
	                               .getRequestDispatcher("/Details.jsp");
	    rd.forward(request, response);
		
	}

	private void saveData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String id = getUniqueId();
		
		User user = new User(id, firstName, lastName, email, gender);
		userList.add(user);
		
		request.setAttribute("userData", userList);
	    RequestDispatcher rd = getServletContext()
	                               .getRequestDispatcher("/Details.jsp");
	    rd.forward(request, response);
	}
	
	private String getUniqueId(){
		String id = "";
		UUID generatedId = UUID.randomUUID();
		id = String.valueOf(generatedId);
		return id;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

