<%@ include file="/init.jsp" %>

<%
    String candidateId = renderRequest.getParameter("candidateId");
    String name = renderRequest.getParameter("name");
    String candidateCompany = renderRequest.getParameter("company");
%>

<p>
	<b><liferay-ui:message key="corporateknowledgetestweb.caption"/></b>
</p>

 <portlet:actionURL var="updateCandidateActionURL" name="/knowledgetest/candidate/save">
             <portlet:param name="redirect" value="${param.redirect}" />
 </portlet:actionURL>
  
<aui:form action="<%= updateCandidateActionURL %>"  name="candidateForm" method="post" >
    <aui:input name="candidateId" type="hidden" value="<%=candidateId%>"/>
    
    <aui:input name="name" type="text" value="<%=name%>"/>
    <aui:input name="company" type="text" value="<%=candidateCompany%>"/>

	<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="cancel"></aui:button>
	</aui:button-row>
</aui:form>
