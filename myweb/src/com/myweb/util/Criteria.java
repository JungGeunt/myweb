package com.myweb.util;

public class Criteria {

	 //select *from board oerder by num desc limit ? (시작위치) , ? (갯수);
	
	private int pageNum; //페이지 번호
	private int count; //페이지 당 게시물 수
	
	public Criteria() {
		//최소 게시판에 진입할 떄 기본값 1번 페이지 ,10개를 데이터로 셋팅
		this.pageNum = 1 ;
		this.count =10 ;
	}
	
	public Criteria(int pageNum, int count) {
		//매개 변수를 전달받아 페이지 풀력 값을 계산 처리하게함.
		this.pageNum = pageNum;
		this.count = count;
	}
	
	//겟터 , 셋터
	public int getPageStart() {// limit ?(*) , ?(count)?
		return (pageNum -1) * count;
	}
	

	public int getPageNum() { 
		return pageNum  ;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
}
