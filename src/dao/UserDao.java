package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import demoProject.User;
import utility.DatabaseConnector;


public class UserDao {
	
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	
	public static void saveUserData(User user){
		conn = DatabaseConnector.getSQLInstance();
		try {
			conn = DatabaseConnector.getSQLInstance();
			String query = "INSERT INTO User VALUES(?,?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getId());
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseConnector.closeConn();
	}
	
	public static void deleteUser(String userId){
		conn = DatabaseConnector.getSQLInstance();
		try {
			conn = DatabaseConnector.getSQLInstance();
			String query = "DELETE FROM User WHERE id = ?";
			pst = conn.prepareStatement(query);
			pst.setString(1, userId);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseConnector.closeConn();
	}
	
	public static List<User> getUserDetails(){
		List<User> userList = new ArrayList<>();
		try {
			conn = DatabaseConnector.getSQLInstance();
			String query = "SELECT * FROM User";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()){
				User user = new User(rs.getString(5), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseConnector.closeConn();
		
		return userList;
	}

	public static User getUser(String userId) {
		User user = null;
		try {
			conn = DatabaseConnector.getSQLInstance();
			String query = "SELECT * FROM User WHERE id = ?";
			pst = conn.prepareStatement(query);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getString(5), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseConnector.closeConn();
		
		return user;
	}

	public static void updateUser(User user) {
		conn = DatabaseConnector.getSQLInstance();
		try {
			conn = DatabaseConnector.getSQLInstance();
			String query = "UPDATE User SET firstName = ?, lastName = ?, email = ?, gender = ? WHERE id = ?";
			pst = conn.prepareStatement(query);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseConnector.closeConn();
	}
	
}