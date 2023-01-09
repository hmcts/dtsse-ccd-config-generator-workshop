package uk.gov.hmcts.demo.ccd.event;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.ccd.sdk.api.CCDConfig;
import uk.gov.hmcts.ccd.sdk.api.CaseDetails;
import uk.gov.hmcts.ccd.sdk.api.ConfigBuilder;
import uk.gov.hmcts.ccd.sdk.api.callback.AboutToStartOrSubmitResponse;
import uk.gov.hmcts.demo.ccd.State;
import uk.gov.hmcts.demo.ccd.UserRole;
import uk.gov.hmcts.demo.ccd.model.CaseData;
import uk.gov.hmcts.reform.ccd.client.model.SubmittedCallbackResponse;

import java.time.LocalDate;
import java.util.List;

import static java.util.List.of;
import static uk.gov.hmcts.ccd.sdk.api.Permission.CRU;
import static uk.gov.hmcts.demo.ccd.State.Closed;
import static uk.gov.hmcts.demo.ccd.State.Open;
import static uk.gov.hmcts.demo.ccd.UserRole.CASE_WORKER;
import static uk.gov.hmcts.demo.ccd.UserRole.CITIZEN;
import static uk.gov.hmcts.demo.ccd.UserRole.SOLICITOR;

@Component
public class SubmitCase implements CCDConfig<CaseData, State, UserRole> {

    @Override
    public void configure(ConfigBuilder<CaseData, State, UserRole> configBuilder) {
        configBuilder
            .event("submit-case")
            .forStateTransition(Open, Closed)
            .name("Submit case")
            .description("Submit case")
            .grant(CRU, SOLICITOR, CITIZEN)
            .grantHistoryOnly(CASE_WORKER)
            .aboutToSubmitCallback(this::aboutToSubmit)
            .submittedCallback(this::submitted)
            .fields()
                .mandatory(CaseData::getDocuments)
                .done();
    }

    private SubmittedCallbackResponse submitted(CaseDetails<CaseData, State> caseDataStateCaseDetails,
                                                                                     CaseDetails<CaseData, State> caseDataStateCaseDetails1) {

        return null;
    }

    private AboutToStartOrSubmitResponse<CaseData, State> aboutToSubmit(CaseDetails<CaseData, State> beforeDetails,
                                                                        CaseDetails<CaseData, State> submittedDetails) {

        if (submittedDetails.getData().getDocuments().isEmpty()) {
            return AboutToStartOrSubmitResponse.<CaseData, State>builder()
                .errors(of("You must upload at least one document"))
                .build();
        } else {
            submittedDetails.getData().setDueDate(LocalDate.EPOCH);

            return AboutToStartOrSubmitResponse.<CaseData, State>builder()
                .data(submittedDetails.getData())
                .state(Closed)
                .build();
        }
    }
}
