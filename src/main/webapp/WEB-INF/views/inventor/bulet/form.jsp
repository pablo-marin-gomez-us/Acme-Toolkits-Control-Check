<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}">
	<h2><acme:message code="inventor.CHIMPUM.message.CHIMPUM"/></h2>
	
	<acme:input-textbox code="inventor.BULET.form.label.code" path="code" readonly="${acme:anyOf(command, 'show, update')}"/>
	<acme:input-textbox code="inventor.BULET.form.label.name" path="name"/>
	<acme:input-textbox code="inventor.BULET.form.label.summary" path="summary"/>
	<acme:input-moment code="inventor.BULET.form.label.creationMoment" path="creationMoment" readonly="true"/>
	<acme:input-moment code="inventor.BULET.form.label.startDate" path="startDate"/>
	<acme:input-moment code="inventor.BULET.form.label.finishDate" path="finishDate"/>
	<acme:input-money code="inventor.BULET.form.label.quota" path="quota"/>
	<acme:input-url code="inventor.BULET.form.label.link" path="link"/>

<jstl:choose>
	<jstl:when test="${command == 'create'}">		
	
<acme:submit code="inventor.BULET.form.button.create" action="/inventor/bulet/create"/>			
</jstl:when>
<jstl:when test="${acme:anyOf(command, 'show, update, delete')}">
<acme:button code="inventor.BULET.form.button.artifact" action="/inventor/artifact/list-bulet?buletId=${id}"/>
<acme:submit code="inventor.artifact.form.button.update" action="/inventor/bulet/update"/>
<acme:submit code="inventor.artifact.form.button.delete" action="/inventor/bulet/delete"/>

</jstl:when>
</jstl:choose>	



</acme:form> 



