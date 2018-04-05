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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create Task</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
   <form:form method="post" modelAttribute="allTask" >
        <table class =" table table-stripped">
             <thead>
                 <tr>
                     <th>TaskId</th>
                     <th>Task</th>
                     <th>Cost</th>
                     <th>CriticalCost</th>
                     <th>EarlyStart</th>
                     <th>EarlyFinish</th>
                     <th>LatestStart</th>
                     <th>LatestFinish</th>
                     <th>DependenciesTaskId</th>
                 </tr>
             </thead>
        <tbody>
            <c:forEach var="task" items="${allTask}">
                <tr>
                    <td><c:out value="${task.id}"/></td>
                    <td><c:out value="${task.name}"/></td>
                    <td><c:out value="${task.cost}"/></td>
                    <td><c:out value="${task.criticalCost}"/></td>
                    <td><c:out value="${task.earlyStart}"/> </td>
                    <td><c:out value="${task.earlyFinish}"/> </td>
                    <td><c:out value="${task.latestStart}"/> </td>
                    <td><c:out value="${task.latestFinish}"/> </td>
                    <td><c:out value="${task.taskDependencies.getId()}"/></td>
                    <td>

                    <a class="btn bt btn-default" href='<spring:url value="/task/edit/${task.id}"/>'>Edit
                    </a>
                <a class="btn btn-default" href='<spring:url value="/task/delete/${task.id}" htmlEscape="true"/>'>Delete</a>
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
        <a class="btn btn-default" href='<spring:url value="/addTask" htmlEscape="true"/>'>Cancel</a>
    </table>
       </a>
       <a class="btn btn-default" href='<spring:url value="/timeTable" htmlEscape="true"/>'>Create TimeTable
       </a>
   </form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>