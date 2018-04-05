<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 29.04.2017
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
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

    <form:form method="POST" modelAttribute="taskForm" >

        <h2 class="form-signin-heading">Create your tasks</h2>



        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="task_name"
                            autofocus="true"></form:input>
                <form:errors path="name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="cost">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="cost" class="form-control" placeholder="cost_task"></form:input>
                <form:errors path="cost"></form:errors>
            </div>
        </spring:bind>


        <label for="id_label_single">
            Choose the dependent task from the list below by clicking on the field



            <select class="js-example-basic-single js-states form-control" id="id_label_single">
                <option value="">TaskA</option>
                <option value="">TaskQ</option>
                <option value="">TaskX</option>
                <option value="">TaskC</option>
                <option value="">TaskF</option>
                <option value="">Start</option>
            </select>
        </label>





                                <button class="btn btn-lg btn-primary btn-block" type="submit">Add Task</button>
                <a class="btn btn-default" href='<spring:url value="/allTask" htmlEscape="true"/>'>View allTask</a>

                            </form:form>

                        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
                        </body>
                        </html>
