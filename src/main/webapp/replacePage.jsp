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
        <div>
            <h2><fmt:message key="play_room_changer"/></h2>
            <h2 style="color: red"><c:out value="${message}"/></h2>
        </div>
        <h2><fmt:message key="here_you_can_replace"/></h2><br/>
        <div class="form-group" style="font-size: medium">
            <form method="post" action="/room/replace">
                <div>
                    <input type="checkbox" id="doll" name="Doll">
                    <label for="doll"><fmt:message key="doll"/></label>
                </div>
                <div>
                    <input type="checkbox" id="pencils" name="Pencils">
                    <label for="pencils"><fmt:message key="pencils"/></label>
                </div>
                <div>
                    <input type="checkbox" id="puzzle" name="Puzzle">
                    <label for="puzzle"><fmt:message key="puzzle"/></label>
                </div>
                <div>
                    <input type="checkbox" id="pyramid" name="Pyramid">
                    <label for="pyramid"><fmt:message key="pyramid"/></label>
                </div>
                <div>
                    <input type="checkbox" id="top" name="Top">
                    <label for="top"><fmt:message key="top"/></label>
                </div>
                <div>
                    <input type="checkbox" id="toycar" name="Toycar">
                    <label for="toycar"><fmt:message key="toy_car"/></label>
                </div>
                </br>
                <div>
                    <input type="text" class="form" id="roomname" name="Roomname" placeholder="<fmt:message key="room_number"/>" pattern="^[0-9]{1,3}" style="display:block;width:130px;padding:.375rem .75rem;font-size:1rem;line-height:1.5;color:#495057;background-color:#fff;background-clip:padding-box;border:1px solid #ced4da;border-radius:.25rem;transition:border-color .15s ease-in-out,box-shadow .15s ease-in-out">
                </div>
                </br>
                <div>
                    <button class="btn btn-warning font-weight-bold" type="submit"><fmt:message key="replace"/></button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
