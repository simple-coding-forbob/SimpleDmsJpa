<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 목록</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 	부트스트랩 css  -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 	개발자 css -->
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="page mt3">
	<form id="listForm" name="listForm">
		<!-- jsp -> 컨트롤러(검색어): input 태그의 name 속성을 이용 -->
		<div class="input-group mb3 mt3">
			<input type="text"
				   class="form-control"
				   placeholder="부서명입력"
				   value="${param.searchKeyword}"
			>
			<button type="button"
					class="btn btn-primary"
					onclick="fn_egov_link_page(0)"
			>
				검색
			</button>
		</div>
		<table class="table">
			<thead>
			<tr>
				<th scope="col">dno</th>
				<th scope="col">dname</th>
				<th scope="col">loc</th>
			</tr>
			</thead>
			<tbody>
			<!-- 반복문 -->
				<tr>
					<td>
							1
					</td>
					<td>2</td>
					<td>3</td>
				</tr>
			</tbody>
		</table>
		<!-- 여기: 페이지번호 -->
		<div class="flex-center">
			<ul class="pagination" id="pagination"></ul>
		</div>

	</form>

</div>
<!-- 꼬리말 -->
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>