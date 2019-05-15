<%@ page contentType="text/html" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${not empty sessionScope.locale ? sessionScope.locale : initParam.locale}"/>
<fmt:setBundle basename="lang"/>

<html>
<head>
    <title>Play Rooms</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
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
    <div style="padding-bottom: 10px">
        <a class="btn btn-warning font-weight-bold" href="index.jsp"><fmt:message key="main"/></a>
        <a class="btn btn-warning font-weight-bold" href="/room/create"><fmt:message key="create_room"/></a>
        <a class="btn btn-warning font-weight-bold" href="/room/replace"><fmt:message key="update_room"/></a><br/>
    </div>
    <div id="content">
        <c:forEach var="playRoom" items="${rooms}">
            <div class="container" id="room-info">
                <div class="row">
                    <div class="col-xl-12" align="center"
                         style="border:1px solid #333; font-weight: bold; font-size: larger; padding: 5px">
                        <h3><c:out value="${playRoom.name}"/></h3>
                        <h4><fmt:message key="created"/>
                            <c:if test="${sessionScope.locale == 'en'}">
                                <c:out value="${playRoom.getCreated()}"/>
                            </c:if>
                            <c:if test="${sessionScope.locale == 'ua'}">
                                <c:out value="${playRoom.getCreatedUa()}"/>
                            </c:if>
                        </h4>
                        <h4><fmt:message key="modified"/>
                            <c:if test="${sessionScope.locale == 'en'}">
                                <c:out value="${playRoom.getModified()}"/>
                            </c:if>
                            <c:if test="${sessionScope.locale == 'ua'}">
                                <c:out value="${playRoom.getModifiedUa()}"/>
                            </c:if>
                        </h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-12" style="border:1px solid #333; font-size: medium">
                        <div style="padding-top: 10px">
                            <img src="${pageContext.request.contextPath}\resources\images\playRoom.png" width="450"
                                 border="0"
                                 style="float: left; padding-top: 15px">
                            <div style="margin-left: 470px">
                                <h4><fmt:message key="toys_in_the_room"/></h4>
                                <c:forEach var="toy" items="${playRoom.toyList}">
                                    <c:if test="${sessionScope.locale == 'en'}">
                                        <li class="list-group-item font-weight-bold"><c:out value="${toy.getName()}"/>
                                            <c:out value="${toy.info()}"/></li>
                                    </c:if>
                                    <c:if test="${sessionScope.locale == 'ua'}">
                                        <li class="list-group-item font-weight-bold"><c:out value="${toy.getUaName()}"/>
                                            <c:out value="${toy.infoUa()}"/></li>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
        </c:forEach>
    </div>
</div>
</body>
</html>
