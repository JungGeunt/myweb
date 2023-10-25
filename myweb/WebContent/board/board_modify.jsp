<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="/include/index_header.jsp"%>
	
	<section>
		<div align="center">
			<form action="update.board" name="bform"  method="post">
				<h2>게시판 글 수정 페이지</h2>
				<table border="1" width="500px">
					<tr>
						<td>글번호</td>
						<td><input type="text" name="num" value="${vo.num}" readonly></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" value="${vo.writer}" readonly></td>
					</tr>
					<tr>
						<td>글 제목</td>
						<td><input type="text" name="title" value="${vo.title }"></td>
					</tr>
					<tr>
						<td>글내용</td>
						<td>
							<textarea rows="10"  style="width:100%"  name="content">${vo.content }</textarea>
						</td>
					</tr>
					<tr>
					<!-- 글등록 메뉴 -->
					<td colspan="2" align="center">
						<input type="button" value="수정" onclick="modifyCheck()">
						<input type="button" value="목록 " onclick="location.href='list.board'">
						<input type="button" value="삭제 " onclick="location.href='delete.board?num=${vo.num}'">
					</td>
					</tr>
				</table>
			</form>		
		</div>
	</section>

	<script>
	function modifyCheck(){
		//작성자 , 글 제목에 공백을 확인, 공백이 아니라면 submit()처리
	   if(document.bform.title.value === ''){
			alert('글제목은 필수 사항입니다.');
			return;
		}else if(confirm('글 등록을 하시겠습니까?')){
			document.bform.submit(); //자바스트립트의submit()
		}
	}
	</script>

<%@ include file="/include/index_footer.jsp"%>