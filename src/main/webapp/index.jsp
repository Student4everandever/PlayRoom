<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${not empty sessionScope.locale ? sessionScope.locale : initParam.locale}" />
<fmt:setBundle basename="lang"/>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
      integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">


<html>
<body>
<div style="padding-left: 15px">
    <div class="page-header" align="center" style="position: relative">
        <div class="lang-icons">
            <a href="${pageContext.request.contextPath}/room/language?locale=en">
                <img src="<c:url value='/resources/images/if_flag-united-kingdom_748024.png'/>">
            </a>
            <a href="${pageContext.request.contextPath}/room/language?locale=ua">
                <img src="<c:url value='/resources/images/if_flag-ukraine_748083.png'/>">
            </a>
        </div>
    </div>
    <div id="content">
        <a class="btn btn-warning font-weight-bold" href="/room/roomList"><fmt:message key="created_rooms"/></a><br/>
        <br>
        <h2><fmt:message key="welcome"/></h2></br>
        <h2><fmt:message key="create_play_room"/></h2></br>
        <form method="post" action="/room/create">
            <div style="font-size: medium">
                <ul>
                    <li><fmt:message key="doll"/></li>
                    <li><fmt:message key="pencils"/></li>
                    <li><fmt:message key="puzzle"/></li>
                    <li><fmt:message key="pyramid"/></li>
                    <li><fmt:message key="top"/></li>
                    <li><fmt:message key="toy_car"/></li>
                </ul>
            </div>
            </br>
            <div>
                <button class="btn btn-warning font-weight-bold" type="submit"><fmt:message key="create"/></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
