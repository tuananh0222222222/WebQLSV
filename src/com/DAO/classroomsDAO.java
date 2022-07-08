package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Model.classrooms;
import com.utils.DBContext;

public class classroomsDAO {

	//lay class
	public static ArrayList<classrooms> getClassrooms(){
		//khai bao
		ArrayList<classrooms> list = null;
		//mo cong ket noi
		Connection con = DBContext.connectDatabase();
		//thuc hien tuy van
		String sql = "select * from classrooms";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// thuc hien truy van
			classrooms classroom = null;
			list = new ArrayList<classrooms>();
					
			while(rs.next()){
				classroom = new classrooms();
				classroom.setId(rs.getInt("Id"));
				classroom.setNameClass(rs.getString("NameClass"));
				//ad vaomang
				list.add(classroom);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	//them
	public static boolean addClassroom(classrooms classroom){
		Connection con = DBContext.connectDatabase();
		String sql = "INSERT INTO `classrooms`( `NameClass`) VALUES ('"+classroom.getNameClass()+"')";
		PreparedStatement ps ;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//sua
	public static classrooms getClassroomId(int Id){
		Connection con = DBContext.connectDatabase();
		classrooms classroom = new classrooms();
		String sql = "select * from classrooms where Id=" + Id;
		PreparedStatement ps ;
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// thuc hien truy van
				
			if(rs.next()){
				
				classroom.setId(rs.getInt("Id"));
				classroom.setNameClass(rs.getString("NameClass"));
	
			}
			return classroom;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean updateClassroom(classrooms classroom){
		Connection con = DBContext.connectDatabase();
		String sql = "UPDATE `classrooms` SET `Id`='"+classroom.getId()+"',`NameClass`='"+classroom.getNameClass()+"' WHERE Id = "+ classroom.getId();
		PreparedStatement ps ;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//xoa
	public static boolean DelClassroom( int Id){
		Connection con = DBContext.connectDatabase();
		String sql = "DELETE FROM `classrooms` WHERE Id =" +Id ;
		PreparedStatement ps ;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
