<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 추가</title>
</head>
<body>
	
	<h3>사용자 추가</h3>
	
	<label>이름 : </label> <input type="text" id="nameInput"> <br>
	<label>생년월일 : </label> <input type="text" id="birthdayInput"> <br>
	<label>이메일 : </label> <input type="text" id="emailInput"> <br>
	<button type="button" id="addBtn">추가</button>

	<script
	  src="https://code.jquery.com/jquery-3.7.1.min.js"
	  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	  crossorigin="anonymous"></script>
	 <script>
	 	$(document).ready(function() {
	 		// 추가 버튼이 클릭되면 
	 		$("#addBtn").on("clicl", function() {
		 		// 입력값을 얻어와서 (사용자가 입력한 값은 val속성을 통해 가져옴)
		 		let name = $("#nameInput").val();
		 		let birthday = $("#birthdayInput").val();
		 		let email = $("#emailInput").val();
		 		
		 		// create API를 호출한다.
	 			$.ajax({
	 				type:"get"
	 				, url:"/ajax/user/create"
	 				, data:{"name":name, "birthday":birthday, "email":email}
	 				, success:function(data) {
	 					// 성공 : {"result":"success"}
	 					// 실패 : {"result":"fail"}
	 					if(data.result == "success") {
	 						// 성공
	 						// 리스트 페이지로 이동
	 						location.href = "/ajax/user/list";
	 					} else {
	 						// 실패
	 						alert("추가 실패!!!");
	 					}
	 				}
	 				, error:function() {
	 					alert("추가 에러!!!");
	 				}
	 			});
	 			
	 		});
	 		
	 	});
	 </script>
	
</body>
</html>