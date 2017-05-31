<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 27.05.2017
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>TaskList</title>
</head>
<body>

<div class="container xd-container">
    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Task</th>
            <th>Dependensies?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${allTask}">
            <tr>
                <td><c:out value="${task.name}"/></td>
                <td><c:out value="${task.cost}"/></td>
                <td>
                    <a class="btn bt btn-default" href='<spring:url value="/task/edit/${task.id}"/>'>Edit
                    </a>
                    <a class="btn btn-default" href='<spring:url value="/task/delete/${task.id}" htmlEscape="true"/>'>Delete
                    </a>
                    <div>
                        <c:if test="${taskId == task.id}">
                            <c:if test="${DeleteError!=null}">
                                <b style="color: #843534">
                                    <c:out value="${DeleteError}"/>
                                </b>
                            </c:if>
                        </c:if>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <a class="btn btn-default" href='<spring:url value="/allTask" htmlEscape="true"/>'>Cancel</a>
    </table>
</div>
</body>
</html>