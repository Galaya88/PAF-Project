package org.restapi.crud.payment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eg-system", "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	
	
	public String readPayments()
	{
			String output = "";
			
			try
			{
					Connection con = connect();
					
					if (con == null)
					{
							return "Error while connecting to the database for reading.";
					}
					
					// Prepare the html table to be displayed
					output = "<table class=\'table table-bordered\' border='1'><tr><th>Id</th>"
							+ "<th>Name</th>"
							+"<th>Unit</th>"
							+ "<th>Amount</th>"
							+ "<th>Update</th><th>Remove</th></tr>";
							
					
					String query = "select * from payment"; // table name payment
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					
					// iterate through the rows in the result set
					while (rs.next())
					{
							String docId = rs.getString("docId");
							String docName = rs.getString("docName");
							String docUnit = rs.getString("docUnit");					
							String docAmount = Integer.toString(rs.getInt("docAmount"));
							
							// Add into the html table
							output += "<tr><td><input id='hidItemIDUpdate'name='hidItemIDUpdate' type='hidden' value='" + docId + "'>" + docId + "</td>";
							output += "<td>" + docName + "</td>";
							output += "<td>" + docUnit + "</td>";
							output += "<td>" + docAmount+ "</td>";
							
							// buttons
							output += "<td><input name='btnUpdate'type='button' value='Update'class='btnUpdate btn btn-success'></td>"
								   + "<td><input name='btnRemove'type='button' value='Remove'class='btnRemove btn btn-danger'data-itemid='"+ docId + "'></td></tr>";
					}
					con.close();
					// Complete the html table
					output += "</table>";
			}
			catch (Exception e)
			{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
			}
			return output;
	}
	
	  public String insertpayments(String docId, String docName, String docUnit, String docAmount) {
			
			String output = "";
			
			try {
					Connection con = connect();

					if (con == null) {
						
						return "Error while connecting to the database";
						
					}
					
					// create a prepared statement
					String query = " insert into payment " + "(`docId`,`docName`,`docUnit`,`docAmount`)"
							+ " values (?,?,?,?)";

					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setString(1, docId	);
					preparedStmt.setString(2, docName);
					preparedStmt.setString(3, docUnit);					
					preparedStmt.setInt(4,Integer.parseInt(docAmount) );
					

					// execute the statement
					preparedStmt.execute();
					con.close();

					String newdoc = readPayments();
					output = "{\"status\":\"success\", \"data\": \"" + newdoc + "\"}";

				}
				catch (Exception e)
				{
					output = "{\"status\":\"error\", \"data\":\"Error while inserting the Payment Deatils.\"}";
					System.err.println(e.getMessage());
				}
				return output;
			}
	  
	  
	  
	  public String UpdatePayments(String docId,String docUnit, String docAmount  ) {
			String output = "";
			try {
				Connection con = connect();

				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = "update payment set docUnit = ?, docAmount= ? where docId = ?";

				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values

				preparedStmt.setString(1, docUnit);
				preparedStmt.setInt(2,Integer.parseInt(docAmount) );

				
				preparedStmt.setString(3, docId);
				

				// execute the statement
				preparedStmt.execute();
				con.close();

				String newdoc = readPayments();
				output = "{\"status\":\"success\", \"data\": \"" + newdoc + "\"}";

			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Error while updating the Payment Details.\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}
	  
	  
	  public String deletepayment(String docId) {
			
			String output = "";

			try {

					Connection con = connect();
		
					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}
		
					// create a prepared statement
					String query = "delete from payment where docId=?";
					
					PreparedStatement preparedStmt = con.prepareStatement(query);
					// binding values
					preparedStmt.setString(1, docId);
		
					// execute the statement
					preparedStmt.execute();
					con.close();
					
					String newdoc = readPayments();
					output = "{\"status\":\"success\", \"data\": \"" + newdoc + "\"}";
			}		
			catch (Exception e)
			{
					output = "{\"status\":\"error\", \"data\":\"Error while deleting a Payment.\"}";
					System.err.println(e.getMessage());
			}
			
			return output;
		}
}
