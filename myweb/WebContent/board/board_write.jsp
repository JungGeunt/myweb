<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="/include/index_header.jsp"%>
	
	<section>
		<div align="center">
			<form action="register.board" name="bform"  method="post" enctype="multipart/form-data">
				<h2>게시판 글 작성 페이지</h2>
				<table border="1" width="500px">
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" size="10"></td>
					</tr>
					<tr>
						<td>글 제목</td>
						<td><input type="text" name="title" size="20"></td>
					</tr>
					<tr>
						<td>파일 첨부</td>
						<td><input type="file" name="file" ></td>
					</tr>
					<tr>
						<td>글내용</td>
						<td>
							<textarea rows="10"  style="width:100%"  name="content"></textarea>
						</td>
					</tr>
					
					<!-- 글등록 메뉴 -->
					<td colspan="2" align="center">
						<input type="button" value="등록" onclick="registCheck()">
						<input type="button" value="목록 " onclick="location.href='list.board'">
					</td>
					</tr>
				</table>
			</form>		
		</div>
	</section>

	<script>
	function registCheck(){
		//작성자 , 글 제목에 공백을 확인, 공백이 아니라면 submit()처리
		if(document.bform.writer.value === ''){
			alert('작성자는 필수 사항입니다.');
			return;
		}else if(document.bform.title.value === ''){
			alert('글제목은 필수 사항입니다.');
			return;
		}else if(confirm('글 등록을 하시겠습니까?')){
			document.bform.submit(); //자바스트립트의submit()
		}
	}	
	</script>

<%@ include file="/include/index_footer.jsp"%>