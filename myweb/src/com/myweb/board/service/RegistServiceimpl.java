package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class RegistServiceimpl implements IBoardService {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//폼에서 전달된 값을 처리 ...
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		try {
			Part filePart = request.getPart("file");
			filePart.getInputStream();	
			
     	String rpath =request.getServletContext().getContextPath();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//System.out.println(writer + title);
		
		//DAO객체 생성
		//DAO객체에 등록 메서드 regist 메서드 호출
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(writer, title ,content);
		

	}

}
