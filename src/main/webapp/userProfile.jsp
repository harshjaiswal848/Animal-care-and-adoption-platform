<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h2>Welcome, ${userName}!</h2>
    <p>Email: ${userEmail}</p>

    <c:choose>
        <c:when test="${not empty userName}">
            <p>Your profile details are displayed above.</p>
        </c:when>
        <c:otherwise>
            <p>No user data available. Please register.</p>
        </c:otherwise>
    </c:choose>

    <a href="register.jsp">Edit Profile</a>
</body>
</html>
