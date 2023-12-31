package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.Criteria;
import com.myweb.util.JdbcUtil;

public class BoardDAO {

	//디자인 패턴 : Singleton 패턴
	
	private DataSource ds;
	//1.스스로 객체를 멤버 변수로 선언 객체 생성을 1개로 제한
	private static BoardDAO instance = new BoardDAO();
	
	//2.외부에서 객체를 생성 할 수 없게 private로 설정
	private BoardDAO() {
		//커넥션풀에서 DB연결 객체 정보를 불러옴...
	try { 
		InitialContext ctx = new InitialContext();
		ds= (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
	} catch (Exception e) {
		System.out.println("커넥션풀링 에러 발생");
	} 
	
}
	//3.외부에서 객체를 요구할때 getter메서드를 통해서 반환
	public static BoardDAO getInstance() {
		return instance;
	}

	//중복 되는 코드를 멤버 변수로 선언 
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;

	//-----------DAO 동장 메서드 구현 CRUD----------------------
	
	public int regist(String writer, String title, String content) {
		
		String sql = "insert into board(writer, title, content)" 
									+ "values(?,?,?)";
		
		String sql2 ="select @@identity";
		 int result =0;
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt("@@identity");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
//파일 등록	
public void registFile(String filename, String filerealname, int num) {
		
		String sql = "insert into file(filename, filerealname, filenum)" 
									+ "values(?,?, ?)";
		
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, filename);
			pstmt.setString(2, filerealname);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}

public int findNumber() {
	
	String sql = "select @@identity as fnum";
	int result =0;
	
	try {
		conn=ds.getConnection();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		result = rs.getInt("fnum");
		
	} catch (Exception e) {
		
	}
	return result;
}

	
	//게시물 목록  조회 메서드
//	public List<BoardVO> getList(){
//		List<BoardVO> list = new ArrayList<>();
//		
//		String sql ="select * from board order by num desc";
//		//맨 처음 작성한 글이 제일먼저 오게 내림 차순 정렬
//		
//		try {
//			conn =ds.getConnection();
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			
//			//BoardVO에 레코드를 정보를 저장하고, 이를 List에 넣기
//			//rs Query의 결과가 있음.
//			
//			while(rs.next()){
//				BoardVO vo = new BoardVO();
//				vo.setNum(rs.getInt("num")); vo.setWriter(rs.getString("writer"));
//				vo.setTitle(rs.getString("title")); vo.setContent(rs.getString("content"));
//				vo.setRegdate(rs.getTimestamp("regdate")); vo.setHit(rs.getInt("hit"));
//				
//				list.add(vo);
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JdbcUtil.close(conn, pstmt, rs);
//		}
//		
//		return list;
//	}
	//페이징 처리 - 게시물 목록 처리
	public List<BoardVO> getList(Criteria cri){
		List<BoardVO> list = new ArrayList<>();
		
		String sql ="select * from board order by num desc limit ? , ?";
		//맨 처음 작성한 글이 제일먼저 오게 내림 차순 정렬
		
		try {
			conn =ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageStart()); //시작 번호
			pstmt.setInt(2, cri.getCount()); //페이지 당 게시물 수
			rs=pstmt.executeQuery();
			
			//BoardVO에 레코드를 정보를 저장하고, 이를 List에 넣기
			//rs Query의 결과가 있음.
			
			while(rs.next()){
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num")); vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title")); vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getTimestamp("regdate")); vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	//총 게시물 수를 반환하는 메서드
	public int getTotal() {
		int result = 0;
		String sql = "select count(*) as total from board";
		
		
		try {
			conn =ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	
	//content 값을 가져오는
		public BoardVO getContent(String num) {
			BoardVO vo =null;
			
			String sql = "select * from board where num = ?";
			
			try {
				conn =ds.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, num);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
				int num2 = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate =rs.getTimestamp("regdate");
				int hit =rs.getInt("hit");
				
				
				 vo = new BoardVO(num2, writer, title, content, regdate, hit);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn, pstmt, rs);
			}	
			return vo;
		}
		
		//게시글 수정 메서드 
		public void update(String num, String title , String content) {

			String sql= "update board set title=?, content=? where num =?";
			
			try {
				conn =ds.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setString(3, num);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
			
		}
		//파일 업로드 메서드
		public void updateFile(String num,  String filename, String filerealname ) {

			String sql= "update file set filename=?, filerealname=? where num =?";
			
			try {
				conn =ds.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, filename);
				pstmt.setString(2, filerealname);
				pstmt.setString(3, num);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
			
		}
		
		
		
		//게시글 삭제 
		public void delete(String num) {
		String sql= "delete from board where num=?";
			
		try {
			conn =ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		}
		
		//조회수를 올려주는 메서드
		public void upHit(String num) {
			
		String sql= "update board set hit = hit + 1  where num=?";
			
			try {
				conn =ds.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, num);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
		}
		
}
