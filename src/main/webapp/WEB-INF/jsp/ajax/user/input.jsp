<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

</head>
<body>
	<h2>사용자 추가</h2>
	
	<label>이름 : </label> <input type="text" id="nameInput"> <br>
	<label>생년월일 : </label> <input type="text" id="birthdayInput"> <br>
	<label>이메일 : </label> <input type="text" id="emailInput"><button type="button" id="dupCheck">중복체크</button><br>
	<button type="button" id="addBtn">추가</button>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			$("#dupCheck").on("click", function(){
				let email = $("#emailInput").val();
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return ;
				}
				
				$.ajax({
					type:"get"
					,url:"/ajax/user/duplicate-email"
					,data:{"email":email}
					,success:function(data) {
						if(data.isDuplicate == true) {
							alert("이메일이 중복됩니다.");
						}else {
							alert("사용가능한 이메일입니다.");
						}
					}
					, error:function() {
						alert("ajax 에러");
					}
						
				});
				
			}); 
		
			$("#addBtn").on("click", function() {
				let name = $("#nameInput").val();
				let birthday = $("#birthdayInput").val();
				let email = $("#emailInput").val();
				
				console.log(name + " " + birthday + " " + email);
				
				// 유효성 검사 (Validation)
				if(name == "") {
					alert("이름을 입력하세요");
					return ;
				}
				
				if(birthday == "") {
					alert("생년월일을 입력하세요");
					return ;
				}
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return ;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/user/create"
					, data:{"name":name , "birthday":birthday , "email":email }
					, success:function(data) {
						// 성공 실패 여부 
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						
						if(data.result == "success") {
							// 성공
							// 리스트 페이지로 이동
							location.href = "/ajax/user/list";
						} else {
							// 실패
							alert("추가 실패!!");
						}
					}
					, error:function() {
						alert("추가 에러!!");
					}
				});
			});
		});
	</script>
</body>
</html>