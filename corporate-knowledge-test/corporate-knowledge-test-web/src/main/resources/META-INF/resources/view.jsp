<%@ include file="./init.jsp" %>


<p>
	<b><liferay-ui:message key="corporateknowledgetestweb.caption"/></b>
</p>

<%  List<Candidate> candidateList = (List<Candidate>)request.getAttribute("candidateList"); %>
<portlet:renderURL var="addCandidateRenderURL">
    <portlet:param name="mvcPath" value="/detail.jsp"/>
    <portlet:param name="mvcRenderCommandName" value="/knowledgetest/candidate/get"/>
</portlet:renderURL>
 
<div class="mb-5">
    <a href="<%= addCandidateRenderURL %>" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Add Candidate
    </a>
</div>
<table class="table table-striped">
    <tr >
        <th>Candidate ID</th>
        <th>Name</th>
        <th>Company</th>
        <th>Location</th>
        <th colspan="2" style="width: 100px">Action</th>
    </tr>
    <c:forEach items="${candidateList}" var="candidate">  
    
        <portlet:renderURL var="action1URL">
            <portlet:param name="mvcPath" value="/detail.jsp"/>
            <portlet:param name="mvcRenderCommandName" value="/knowledgetest/candidate/get"/>
            <portlet:param name="name" value="${candidate.name}"/>
            <portlet:param name="company" value="${candidate.company}"/>
            <portlet:param name="candidateId" value="${candidate.candidateId}"/>
        </portlet:renderURL>
        
        
        <portlet:actionURL var="action2URL" name="/knowledgetest/candidate/delete">
            <portlet:param name="candidateId" value="${candidate.candidateId}"/>
        </portlet:actionURL>
                
        <tr> 
      
        	<!-- TODO 5.b Completar la tabla de la vista view.jsp para que se muestre el listado de candidatos ordenado -->
          	   <td class="text-center" style="width: 50px">
                ${candidate.candidateId}
            </td> 
               <td class="text-center" style="width: 50px">
               ${candidate.name}
            </td> 
               <td class="text-center" style="width: 50px">
                ${candidate.company}
            </td> 
               <td class="text-center" style="width: 50px">
                ${candidate.location}
            </td> 
            <td class="text-center" style="width: 50px">
                <a id="accion1" href="<%=action1URL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
                <i class ="glyphicon glyphicon-edit"></i>
                </a>
            </td> 
            <td class="text-center" style="width:50px">
                <a id="accion2" href="<%=action2URL%>" 
                    class="btn  btn-primary btn-default btn-sm px-2 py-1"
                    onclick="return confirm('Are you sure you want to confirm this action?');"> 
                    <i class ="glyphicon glyphicon-remove"></i>
                </a>
            </td>                                     
         </tr>
    </c:forEach>
</table>
