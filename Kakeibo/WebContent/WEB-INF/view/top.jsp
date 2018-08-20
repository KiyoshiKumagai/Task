<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Dto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿</title>
</head>
<body>

<header>
<h1>家計簿</h1>
<ul>
<li><a>記入</a></li>
</ul>
</header>
<table>
	<tr>
		<th>年月日</th>
		<th>内容</th>
		<th>収入／出資</th>
		<th>金額</th>
	</tr>
	<%
		request.setCharacterEncoding("UTF-8");
		String judg;
		ArrayList<Dto> array = (ArrayList<Dto>)request.getAttribute("all");
		for (Dto shushi : array) {
			if(1 == shushi.getJudgment()) {
				judg = "収入";
			} else if (2 == shushi.getJudgment()) {
				judg = "出資";
			} else {
				judg = "";
			}
	%>
	<tr>
		<td><%=shushi.getYear() %>/<%=shushi.getMonth() %>/<%=shushi.getDay() %></td>
		<td><%=shushi.getContent() %></td>
		<td><%=judg %></td>
		<td><%=shushi.getMoney() %></td>
	</tr>
	<%
		}
	%>
</table>
<footer>
</footer>
</body>
</html>