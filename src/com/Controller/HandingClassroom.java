package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.classroomsDAO;
import com.Model.classrooms;

/**
 * Servlet implementation class HandingClassroom
 */
@WebServlet("/HandingClassroom")
public class HandingClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandingClassroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		int Id = Integer.parseInt(request.getParameter("classroom-id"));
		String classrooName = request.getParameter("classroom-name");
//		PrintWriter pr = response.getWriter();
//		pr.print(classrooName);
		
		classrooms classroom = new classrooms();
		classroom.setId(Id);
		classroom.setNameClass(classrooName);
		
		if(classroomsDAO.updateClassroom(classroom)){
			response.sendRedirect("Classroom/Classroom-list.jsp");
		}else{
			response.sendRedirect("Classroom/Classroom-edit.jsp");

		}
		
		
	}

}
