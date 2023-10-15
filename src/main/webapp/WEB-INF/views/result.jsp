<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/14/2023
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${notFound}
<br>
English: ${result.english}
<br>
Vietnamese: ${result.vietnamese}
<br>
<a href="homeSearch">Back to search</a>
</body>
</html>
