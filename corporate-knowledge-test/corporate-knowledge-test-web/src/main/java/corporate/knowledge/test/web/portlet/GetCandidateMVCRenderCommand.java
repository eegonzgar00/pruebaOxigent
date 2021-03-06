package corporate.knowledge.test.web.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.corporate.knowledge.test.model.Candidate;
import com.corporate.knowledge.test.service.CandidateLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import corporate.knowledge.test.web.constants.CorporateKnowledgeTestWebPortletKeys;

/* @formatter:off */
@Component(
		immediate = true,
		property = { 
				"javax.portlet.name=" + CorporateKnowledgeTestWebPortletKeys.CORPORATEKNOWLEDGETESTWEB, 
				"mvc.command.name=" + "/knowledgetest/candidate/get" 
		},
		service = MVCRenderCommand.class
)
/* @formatter:ON */
public class GetCandidateMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
	private CandidateLocalService candidateLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		
		long candidateId = ParamUtil.getLong(renderRequest, "candidateId");
		Candidate candidate = candidateLocalService.fetchCandidate(candidateId);
		renderRequest.setAttribute("candidate", candidate);
		
		return "/view.jsp";
	}

}
