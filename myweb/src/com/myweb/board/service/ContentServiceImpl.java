package com.myweb.board.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ContentServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * 1.DAO에 getContent(num) 메서드를 생성하고 , 호출
		 * 2.getContent() 메서드에서는 num 을 가지고 , 게시글에 대한 정보를 조회
		 *  vo에 그 정보를 담아서 반환
		 * 3.메서드 리턴 타입 BoardVO
		 * 4.화면 전송을 위해서 리턴 타입의 값을 vo라는 이름으로 강제 저장.
		 * 	경로 이름 :board_content.jsp (커트롤러에서)
		 */
		
		//조회수 업데이트 처리...
		String num = request.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();
		
		//3.쿠키는 서버로 전송될 떄 자동으롷 request 객체 담아져서 들어옴. 쿠키 검사
		Cookie[] arr = request.getCookies();

			
		//1.조회수 업데이트 :dao.upHit(num)
		
		//검증 처리
		boolean bool = true;
		for (Cookie c : arr) {
			if(c.getName().equals("hitNum"+num)) {
				 bool = false;
				 break;
			}
		}
		//검증 후 조회수 업데이트 처리....
		if(bool) dao.upHit(num); //bool 값이 true라면 읽은적 없음. false면 읽은적 있음.
		
		BoardVO vo = dao.getContent(num);
		
		request.setAttribute("vo", vo);
		
		//중복 증가 반지를 위한 쿠기 생성
		Cookie hitCoo = new Cookie("hitNum"+num, num); //num은 게시글 번호 
		hitCoo.setMaxAge(60);
		response.addCookie(hitCoo);

	}

}
