package com.myweb.board.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.annotation.MultipartConfig;
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

		InputStream fis = null;
		FileOutputStream fos = null;
		String fileName =null;
		
		try {
			Part filePart = request.getPart("file");
			 fis  = filePart.getInputStream();
		    fileName = filePart.getSubmittedFileName(); 

     	   String realpath =request.getServletContext().getRealPath("/upload");
     	   System.out.println("리얼패스" + realpath);
     	   
     	   String filepath = realpath + File.separator + fileName;
     	   fos = new FileOutputStream(filepath);
     	   
     	  byte[] buf = new byte[1024];
     		int size =0;
     	   while((size=fis.read(buf)) != -1) 
     	    fos.write(buf,0,size);
     	   
     	  
     	  
     	   
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {				
			}
		}
		
		
		
		//System.out.println(writer + title);
		
		//DAO객체 생성
		//DAO객체에 등록 메서드 regist 메서드 호출
		
		BoardDAO dao = BoardDAO.getInstance();
		int num = dao.regist(writer, title ,content);
		
		
		
		System.out.println("숫자" + num);
		dao.registFile(fileName, fileName , num);
		
	
	}

}
