package com.myweb.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int num;
	private String writer;
	private String title;
	private String content;
	private Timestamp regdate;
	private int hit;
	private String filename;
	private String filerealname;
	
	
	//기본 생성자
	public BoardVO() {	
	}


	public BoardVO(int num, String writer, String title, String content, Timestamp regdate, int hit, String filename,
			String filerealname) {
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.filename = filename;
		this.filerealname = filerealname;
	}

	public BoardVO(int num, String writer, String title, String content, Timestamp regdate, int hit) {
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		
	}

	

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getFilerealname() {
		return filerealname;
	}


	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}


	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", regdate="
				+ regdate + ", hit=" + hit + ", filename=" + filename + ", filerealname=" + filerealname + "]";
	}

	


	

}
