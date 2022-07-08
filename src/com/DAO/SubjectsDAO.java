package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Model.Subjects;
import com.Model.classrooms;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.utils.DBContext;



public class SubjectsDAO {

	//lay danh sach
	public static ArrayList<Subjects> getSubject(){
		//khai bao
		ArrayList<Subjects> list = null;
		//mo cong ket noi
		Connection con = DBContext.connectDatabase();
		//thuc hien truy van
		String sql = "select * from subjects";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Subjects subject = null;
			list = new ArrayList<Subjects>();
			while(rs.next()){
				subject = new Subjects();
				subject.setId(rs.getInt("Id"));
				subject.setNameSubject(rs.getString("NameSubject"));
				//add vao mang
				list.add(subject);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
	//them
	public static boolean addSubject(Subjects subject){
		//mo cong ket noi
		Connection con = DBContext.connectDatabase();
		String sql = "INSERT INTO `Subjects` (NameSubject) VALUES ('"+subject.getNameSubject()+"') ";
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
	public static Subjects getSubjectId(int Id){
		Connection con = DBContext.connectDatabase();
		Subjects subject = new Subjects();
		String sql = "SELECT * FROM subjects WHERE Id =" + Id;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				subject.setId(rs.getInt("Id"));
				subject.setNameSubject(rs.getString("NameSubject"));
			}
			return subject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean updateSubject(Subjects subject){
		Connection con = DBContext.connectDatabase();
		String sql = "UPDATE `subjects` SET `Id`='"+subject.getId()+"',`NameSubject`='"+subject.getNameSubject()+"' WHERE Id =" +subject.getId();
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
	
	public static boolean delSubject(int Id){
		Connection con = DBContext.connectDatabase();
		String sql = "DELETE FROM `subjects` WHERE Id=" +Id;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}










