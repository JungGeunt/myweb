package com.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do" )
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MainController() {
        super();
 
    }

    /*
     * 이 생성된 서블릿을 이용하여 다른 페이지에 접근 할 수 있게 만들어 보자
     * Member네비게이트 클릭시(member.do)에 /member/member.jsp로 접근 할 수 있게 만들기
     * index.do나 member.do가 아닌 경우에는(*.do인 형태인 경우)에는 무조건  Home으로 접근하게 설정 
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//    RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
//	dp.forward(request, response);
	
	String uri = request.getRequestURI(); // uri 받아오는 메서드
	String path = request.getContextPath(); //context 경로를
	String command =uri.substring(path.length()); //uri에 context경로 이후로 문자열 자르기
	System.out.println(command);
	
	if(command.equals("/member.do")) {
		RequestDispatcher dp = request.getRequestDispatcher("member/member.jsp");
		dp.forward(request, response);
		
	}else {
		RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
		dp.forward(request, response);
		
	}
	
	}
	//get은 그냥요청 post는 정보를 담고 요청

}
