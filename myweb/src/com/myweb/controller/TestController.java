package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.DnsSrv.SrvRecord;


//@WebServlet("/TestController") 맵핑하는 부분
@WebServlet("*.test")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestController() {
        super();
         }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response); //어떤 경우에도 doAcction 보내세요
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String uri = request.getRequestURI(); // uri 받아오는 메서드
		String path = request.getContextPath(); //context 경로를
		String command =uri.substring(path.length()); //uri에 context경로 이후로 문자열 자르기
		
//		System.out.println(uri);
//		System.out.println(path);
		System.out.println(command);
	}
}
