<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readOnly}">
	<h2><acme:message code="patron.CHIMPUM.message.CHIMPUM"/></h2>
	
	<acme:input-textbox code="patron.CHIMPUM.form.label.pattern" path="pattern"/>
	<acme:input-textbox code="patron.CHIMPUM.form.label.title" path="title"/>
	<acme:input-textbox code="patron.CHIMPUM.form.label.description" path="description"/>
	<acme:input-moment code="patron.CHIMPUM.form.label.creationMoment" path="creationMoment" readonly="true"/>
	<acme:input-moment code="patron.CHIMPUM.form.label.startDate" path="startDate"/>
	<acme:input-moment code="patron.CHIMPUM.form.label.finishDate" path="finishDate"/>
	<acme:input-money code="patron.CHIMPUM.form.label.budget" path="budget"/>
	<acme:input-url code="patron.CHIMPUM.form.label.link" path="link"/>

<jstl:choose>
	<jstl:when test="${command == 'create'}">		
	
<acme:submit code="patron.CHIMPUM.form.button.create" action="/patron/chimpum/create"/>			
</jstl:when>
<jstl:when test="${acme:anyOf(command, 'show, update, delete')}">
<acme:button code="patron.CHIMPUM.form.button.artifact" action="/patron/artifact/list-chimpum?chimpumId=${id}"/>
<acme:submit code="patron.artifact.form.button.update" action="/patron/chimpum/update"/>
<acme:submit code="patron.artifact.form.button.delete" action="/patron/chimpum/delete"/>

</jstl:when>
</jstl:choose>	



</acme:form> 



