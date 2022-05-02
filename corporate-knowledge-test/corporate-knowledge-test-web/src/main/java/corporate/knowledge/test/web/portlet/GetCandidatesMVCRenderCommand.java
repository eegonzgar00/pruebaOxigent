package corporate.knowledge.test.web.portlet;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.corporate.knowledge.test.model.Candidate;
import com.corporate.knowledge.test.service.CandidateLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import corporate.knowledge.test.web.constants.CorporateKnowledgeTestWebPortletKeys;

/* @formatter:off */
@Component(
		immediate = true,
		property = { 
				"javax.portlet.name=" + CorporateKnowledgeTestWebPortletKeys.CORPORATEKNOWLEDGETESTWEB, 
				"mvc.command.name=" + "/" 
		},
		service = MVCRenderCommand.class
)
/* @formatter:ON */
public class GetCandidatesMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
	private CandidateLocalService candidateLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	
		// TODO Ejercicio 5.a Modificar el código para recuperar y enviar los candidatos de manera ordenada mediante el método getAllCandidatesOrdered implementado en el apartado 3.a
		List<Candidate> candidates = candidateLocalService.getAllCandidatesOrdered();

		renderRequest.setAttribute("candidateList", candidates);


		return "/view.jsp";
	}

}
