package uk.gov.hmcts.demo.ccd.event;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.ccd.sdk.api.CCDConfig;
import uk.gov.hmcts.ccd.sdk.api.ConfigBuilder;
import uk.gov.hmcts.demo.ccd.State;
import uk.gov.hmcts.demo.ccd.UserRole;
import uk.gov.hmcts.demo.ccd.model.Applicant;
import uk.gov.hmcts.demo.ccd.model.CaseData;
import uk.gov.hmcts.demo.ccd.model.Complaint;

import static uk.gov.hmcts.ccd.sdk.api.Permission.CRU;
import static uk.gov.hmcts.demo.ccd.State.Open;
import static uk.gov.hmcts.demo.ccd.UserRole.CASE_WORKER;
import static uk.gov.hmcts.demo.ccd.UserRole.CITIZEN;
import static uk.gov.hmcts.demo.ccd.UserRole.SOLICITOR;

@Component
public class CreateCase implements CCDConfig<CaseData, State, UserRole> {

    @Override
    public void configure(ConfigBuilder<CaseData, State, UserRole> configBuilder) {
        configBuilder
            .event("create-case")
            .initialState(Open)
            .name("Create case")
            .description("Create a brand new case")
            .showSummary()
            .showEventNotes()
            .endButtonLabel("Create Application")
            .grant(CRU, SOLICITOR, CITIZEN)
            .grantHistoryOnly(CASE_WORKER)
            .fields()
                .page("Create Your Case")
                .label("labelSubmitApplicant", "## A heading in XUI")
                .complex(CaseData::getApplicant1)
                    .mandatoryWithLabel(Applicant::getFirstName, "Applicant 1 name")
                    .optionalWithLabel(Applicant::getLastName, "Applicant 1 surname")
                    .done()
                .complex(CaseData::getComplaint)
                    .mandatory(Complaint::getComplaint)
                    .optional(Complaint::getDate)
                    .done()
                .readonly(CaseData::getDueDate)
                .done();
    }
}
