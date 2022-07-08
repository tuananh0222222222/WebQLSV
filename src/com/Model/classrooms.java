package com.Model;

public class classrooms {

	public classrooms() {
		// TODO Auto-generated constructor stub
	}
	
	private int Id;
	private String NameClass;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNameClass() {
		return NameClass;
	}
	public void setNameClass(String nameClass) {
		NameClass = nameClass;
	}
	
	public classrooms(int id, String nameClass) {
		super();
		Id = id;
		NameClass = nameClass;
	}
	

}
