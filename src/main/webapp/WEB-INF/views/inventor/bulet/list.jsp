<%@ page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.BULET.list.label.code" path="code"/>
	<acme:list-column code="inventor.BULET.list.label.name" path="name"/>
	<acme:list-column code="inventor.BULET.list.label.summary" path="summary"/>
	<acme:list-column code="inventor.BULET.list.label.startDate" path="startDate"/>
	<acme:list-column code="inventor.BULET.list.label.finishDate" path="finishDate"/>
	<acme:list-column code="inventor.BULET.list.label.quota" path="quota"/>
	<acme:list-column code="inventor.BULET.list.label.link" path="link"/>
</acme:list>

<acme:button  code="inventor.BULET.list.button.create" action="/inventor/bulet/create"/>