<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿：登録</title>
</head>
<body>
	<h1>家計簿</h1>
	<h2>登録</h2>
	<form action="Kakeibo/TourokuResult" method="post">
		<table>
			<tr>
				<th>日付</th>
				<td>
					<select name="yaer">
						<%
							request.setCharacterEncoding("UTF-8");
							int i;
							int yaerMin = 1900, yaerMax = 2100;
							int month = 12;
							int day = 31;
							for(i = yaerMin; i <= yaerMax; i++) {
						%>
						<option value="<%=i %>"><%=i %></option>
						<%
							}
						%>
					</select>
					<select name="month">
						<%
							for(i = 1; i <= month; i++) {
						%>
						<option value="<%=i %>"><%=i %></option>
						<%
							}
						%>
					</select>
					<select name="day">
						<%
							for(i = 1; i <= day; i++) {
						%>
						<option value="<%=i %>"><%=i %></option>
						<%
							}
						%>
					</select>

				</td>
			</tr>
			<tr>
				<th>内容</th>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<th>収支</th>
				<td>
					<select name="judg">
						<option value="1">収入</option>
						<option value="2">支出</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>金額</th>
				<td><input type="text" name="money"></td>
			</tr>
		</table>
		<input type="submit" value="登録">
	</form>
</body>
</html>