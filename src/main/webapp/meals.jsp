
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>MEALS LIST</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <%--<th></th>--%>
        <%--<th></th>--%>
    </tr>

    <c:forEach items="${meals}" var="meal">
    <tr>
        <%--<td>${meal.description}</td>--%>
        <%--<td>${meal.calories}</td>--%>
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
            <td>
                    ${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}
                    <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                    <%--${fn:formatDateTime(meal.dateTime)}--%>
            </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <%--<td><a href="meals?action=update&id=${meal.id}">Update</a></td>--%>
            <%--<td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>--%>
        </tr>
    </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
