package corporate.knowledge.test.web.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.corporate.knowledge.test.service.CandidateLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import corporate.knowledge.test.web.constants.CorporateKnowledgeTestWebPortletKeys;

/* @formatter:off */
@Component(
		immediate = true,
		property = { 
				"javax.portlet.name=" + CorporateKnowledgeTestWebPortletKeys.CORPORATEKNOWLEDGETESTWEB, 
				"mvc.command.name=" + "/knowledgetest/candidate/delete" 
		},
		service = MVCActionCommand.class
)
/* @formatter:ON */
public class DeleteCandidateMVCActionCommand implements MVCActionCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(DeleteCandidateMVCActionCommand.class);

	@Reference
	private CandidateLocalService candidateLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
    	try {
    		LOGGER.info("processActionDelete");
    		long candidateId = ParamUtil.getLong(actionRequest, "candidateId");
            if(candidateId > 0) {
    			candidateLocalService.deleteCandidate(candidateId);
            }
        } catch (PortalException e) {
        	LOGGER.error("No se ha podido borrar el candidato",e);
			return false;
		}

		return true;
	}

}
