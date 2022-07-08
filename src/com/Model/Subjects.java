package com.Model;

public class Subjects {

	public Subjects() {
		
		super();
	}
	private int Id;
	private String NameSubject;
	public Subjects(int id, String nameSubject) {
		super();
		Id = id;
		NameSubject = nameSubject;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNameSubject() {
		return NameSubject;
	}
	public void setNameSubject(String nameSubject) {
		NameSubject = nameSubject;
	}
	
	
}
