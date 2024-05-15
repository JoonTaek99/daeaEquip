package com.daea.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daea.daos.EquiDao;
import com.daea.dtos.EquiDto;


@WebServlet("*.board")
public class EquiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("command값:" + command);
		
		EquiDao dao = new EquiDao();
		HttpSession session = request.getSession();
		
		if (command.equals("/boardList.board")) {
			// 글 목록
			List<EquiDto> list = dao.getAllData();
			request.setAttribute("list", list);
			dispatch("board/boardList.jsp", request, response);
		} else if (command.equals("/insertDataForm.board")) {
			dispatch("board/insertDataForm.jsp", request, response);
		} else if (command.equals("/insertData.board")) {
			String id = request.getParameter("id");
			String model = request.getParameter("model");
			String manufacturer = request.getParameter("manufacturer");
			String operator = request.getParameter("operator");
			String department = request.getParameter("department");
			String ip = request.getParameter("ip");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date acqdate = null;
			try {
				acqdate = dateFormat.parse(request.getParameter("acqdate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			EquiDto dto = new EquiDto();
			dto.setId(id);
			dto.setModel(model);
			dto.setManufacturer(manufacturer);
			dto.setOperator(operator);
			dto.setDepartment(department);
			dto.setIP(ip);
			dto.setAcqdate(acqdate);
			
			if (dao.insertData(dto)) {
				response.sendRedirect("boardList.board");
			} else {
				dispatch("board/insertDataForm.jsp", request, response);
			}
		} else if (command.equals("/searchData.board")) {
			System.out.println("검색 실행");
			String keyword = request.getParameter("keyword");
			System.out.println("전달받은 keyword" + keyword);
			List<EquiDto> list = dao.searchData(keyword);
			request.setAttribute("list", list);
			System.out.println("검색된 리스트"+list);
			dispatch("board/boardList.jsp", request, response);
		}
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}



}