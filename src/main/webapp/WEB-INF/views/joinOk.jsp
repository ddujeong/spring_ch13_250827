<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 내역</title>
</head>
<body>
	 <h2>회원 가입 내역</h2>
	 <hr>
	 아이디 : ${memberDto.mid }<br><br>
	 비밀번호 : ${memberDto.mpw }<br><br>
	 이름 : ${memberDto.mname }<br><br>
	 나이 : ${memberDto.mage }<br><br>
</body>
</html>