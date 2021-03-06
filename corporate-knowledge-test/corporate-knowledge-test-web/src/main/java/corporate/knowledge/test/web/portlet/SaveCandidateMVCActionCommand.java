package corporate.knowledge.test.web.portlet;

import com.corporate.knowledge.test.helper.ICandidateHelperService;
import com.corporate.knowledge.test.service.CandidateLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import corporate.knowledge.test.web.constants.CorporateKnowledgeTestWebPortletKeys;

/* @formatter:off */
@Component(
		immediate = true,
		property = { 
				"javax.portlet.name=" + CorporateKnowledgeTestWebPortletKeys.CORPORATEKNOWLEDGETESTWEB, 
				"mvc.command.name=" + "/knowledgetest/candidate/save" 
		},
		service = MVCActionCommand.class
)
/* @formatter:ON */
public class SaveCandidateMVCActionCommand implements MVCActionCommand {
	
	// TODO Ejercicio 1.b: Inyectar mediante referencia varios servicios en el command:	CandidateLocalService, CounterLocalService y ICandidateHelperService
	
	@Reference
	private CandidateLocalService candidateLocalService;
	
	@Reference
	private CounterLocalService counterLocalServic;
	
	@Reference
	private ICandidateHelperService ICandidateHelperService;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
    	boolean valido = false;
		// TODO Ejercicio 4.a: Completar la acción o método de processAction de SaveCandidateMVCActionCommand para que actualice o guarde un candidato, según esté informado o no el parámetro candidateId
		final ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final String name = ParamUtil.getString(actionRequest, "name");
        final String company = ParamUtil.getString(actionRequest, "company");
        final long id = ParamUtil.getLong(actionRequest, "candidateId");
        if(ICandidateHelperService.validateName(name)) {
        	candidateLocalService.crearCandidato(company, name);
        	valido = true;
        }
		return valido;
	}

}