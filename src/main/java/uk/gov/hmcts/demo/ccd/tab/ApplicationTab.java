package uk.gov.hmcts.demo.ccd.tab;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.ccd.sdk.api.CCDConfig;
import uk.gov.hmcts.ccd.sdk.api.ConfigBuilder;
import uk.gov.hmcts.demo.ccd.State;
import uk.gov.hmcts.demo.ccd.UserRole;
import uk.gov.hmcts.demo.ccd.model.CaseData;

import static uk.gov.hmcts.demo.ccd.UserRole.CASE_WORKER;
import static uk.gov.hmcts.demo.ccd.UserRole.SOLICITOR;

@Component
public class ApplicationTab implements CCDConfig<CaseData, State, UserRole> {

    @Override
    public void configure(final ConfigBuilder<CaseData, State, UserRole> builder) {
        builder
            .tab("application", "Application")
            .showCondition("applicant1FirstName!=''")
            .forRoles(CASE_WORKER, SOLICITOR)
            .field("hyphenatedCaseReference", "hyphenatedCaseReference=alwaysFalse")
            .label("Label-Heading", null, "### Case Ref: ${hyphenatedCaseReference}")
                .label("Label-Applicant1", null, "## Applicant 1")
                    .field(CaseData::getApplicant1FirstName)
                    .field(CaseData::getApplicant1LastName)
                .label("Label-Applicant2", null, "## Applicant 2")
                    .field(CaseData::getApplicant2FirstName)
                    .field(CaseData::getApplicant2LastName);
    }
}