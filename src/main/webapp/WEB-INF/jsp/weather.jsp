<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="<c:url value = "/resource/css/bootstrap.min.css"/>">
</head>
<body>


<div class="row">
    <div class="col-sm-3">

    </div>
    <div class="col-sm-6">
        <div class="card text-center">
            <div class="card-header">

                <div class="form-group">
                    <label for="locationListId">City</label>
                    <select id="locationListId" class="form-control">
                        <option value="" selected disabled hidden>Choose here</option>
                        <c:forEach var="location" items="${locationDetailsList}">
                            <option id="${location.code}" value="${location.code}">${location.name}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <div class="card-body" id="dataTable">
                <table class="table">
                    <tbody id="tableData"></tbody>

                </table>
            </div>
        </div>
    </div>
</div>

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
                renderData(data);
            },
            error: function (e) {
                alert(e);
            }
        });
    });

    function  renderData(data) {
        var table = document.getElementById("tableData");
        table.innerHTML = '';
        if(data.status){
            var cityName = data.data.cityName;
            var updatedTime = data.data.updatedTime;
            var weather =  data.data.weather;
            var wind = data.data.wind;
            var temperature = data.data.temperature;
            var lableList = ["Updated time","Weather","Temperature","Wind"];
            var valueList = [updatedTime,weather,temperature,wind];

            for (i = 0; i < lableList.length; i++) {
                var rowUpdatedTime = table.insertRow(0);
                var cell1 = rowUpdatedTime.insertCell(0);
                var cell2 = rowUpdatedTime.insertCell(1);
                cell1.innerHTML = lableList[i];
                cell2.innerHTML = valueList[i];
            }


        } else {
            table.innerHTML = 'Something went wrong';
        }
    }


</script>
</body>
</html>
