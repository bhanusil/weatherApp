<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>
<body>

Location
<select id="locationListId">
    <c:forEach var="location" items="${locationDetailsList}">
        <option id="${location.code}" value="${location.code}">${location.name}</option>
    </c:forEach>
</select>

<script>

    $("#locationListId").change(function(){
        var locationCode = $(this).val();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/weatherapp/api/weather-details",
            data: JSON.stringify({"locationCode":locationCode}),
            dataType: 'json',
            success: function (data) {
                alert(data);
            },
            error: function (e) {
                alert(e);
            }
        });
    });


</script>
</body>
</html>
