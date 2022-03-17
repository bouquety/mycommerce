<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>category Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<c:if test="${ERROR_TYPE_ID_PRODUCT}">
    <p>Category id must be an integer</p>
</c:if>

<c:if test="${ERROR_UNKNOWN_PRODUCT}">
    <p>Category does not exist</p>
</c:if>

<c:if test="${not empty category}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
        </tr>
    </table>
</c:if>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
