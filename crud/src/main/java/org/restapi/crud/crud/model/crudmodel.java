package org.restapi.crud.crud.model;

public class crudmodel {
	
	private int payid;
	private String name;
	private String date;
	private String amount;
	
	public crudmodel() {
		
	}
	public crudmodel(int payid,String name, String date, String amount) {
		super();
		this.payid = payid;
		this.name = name;
		this.date = date;
		this.amount = amount;
	}
	public int getPayid() {
		return payid;
	}
	public void setPayid(int payid) {
		this.payid = payid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
