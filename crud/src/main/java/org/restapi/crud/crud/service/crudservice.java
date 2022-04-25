package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.crud.model.crudmodel;

public class crudservice {
	
	
	Connection con;

	public crudservice(){
		try {
			String url ="jdbc:mysql://localhost:3306/users";
			String uname ="root";
			String pwd ="";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
	}
	
	public crudmodel insertUser(crudmodel user) {
		String insert = "insert into person(name,date,amount) values(?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getDate());
			ps.setString(3, user.getAmount());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data inset unsucces.");
			
		}
		
		return user;
		
	}
	
	public ArrayList<crudmodel> getUser() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from person";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setName(rs.getString("name")); //column name
			model.setDate(rs.getString("date"));
			model.setAmount(rs.getString("amount"));
			
			data.add(model);
		
		}
		
		return data;
		
	}
	
	public ArrayList<crudmodel> getUserById(int payid) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();	
		String select = "select * from person where payid =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,payid);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setName(rs.getString("name")); //column name
			model.setDate(rs.getString("date"));
			model.setAmount(rs.getString("amount"));
			
			data.add(model);
		}
		return data;
		
	}
	
	
	public crudmodel updatetUser(crudmodel user) {
		String insert = "update person set name= ? , date=? , amount=? where payid =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getDate());
			ps.setString(3, user.getAmount());
			ps.setInt(4, user.getPayid());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data inset unsucces.");
			
		}
		
		return user;
		
	}
	
	public int deleteUser(int payid) {
		String insert = "delete from person where payid =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,payid);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data inset unsucces.");
			
		}
		
		return payid;
		
	}
	

}

