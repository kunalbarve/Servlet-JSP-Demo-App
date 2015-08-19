package demoProject;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
			}else if(method.equalsIgnoreCase("getUsersDetails")){
				displayUserDetails(request, response);
			}else if(method.equalsIgnoreCase("updateData")){
				updateUser(request, response);
			}else if(method.equalsIgnoreCase("saveUpdatedData")){
				saveUpdatedData(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private void saveUpdatedData(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String id = request.getParameter("userId");
		
		User user = new User(id, firstName, lastName, email, gender);
		UserDao.updateUser(user);
		
		List<User> userData = UserDao.getUserDetails();
		
		request.setAttribute("userData", userData);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Details.jsp");
	    rd.forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String userId = request.getParameter("id");
		User user = UserDao.getUser(userId);
		
		if(user != null){
			request.setAttribute("userData", user);
		}else{
			request.setAttribute("userData", new User());
		}
		
		request.setAttribute("mode", "EDIT");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home.jsp");
	    rd.forward(request, response);
	}

	private void displayUserDetails(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List<User> userData = UserDao.getUserDetails();
		request.setAttribute("userData", userData);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Details.jsp");
	    rd.forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String userId = request.getParameter("id");
		UserDao.deleteUser(userId);
		
		List<User> userData = UserDao.getUserDetails();
		request.setAttribute("userData", userData);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Details.jsp");
	    rd.forward(request, response);
	}

	private void saveData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String id = getUniqueId();
		
		User user = new User(id, firstName, lastName, email, gender);
		UserDao.saveUserData(user);
		
		List<User> userData = UserDao.getUserDetails();
		
		request.setAttribute("userData", userData);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Details.jsp");
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

