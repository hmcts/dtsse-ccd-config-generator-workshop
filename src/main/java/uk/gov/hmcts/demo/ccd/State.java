package uk.gov.hmcts.demo.ccd;

import uk.gov.hmcts.ccd.sdk.api.CCD;
import uk.gov.hmcts.demo.ccd.access.ApplicantAccess;
import uk.gov.hmcts.demo.ccd.access.CaseworkerCaaAccess;

public enum State {

    @CCD(
        label = "Open case",
        hint = "### Case number: ${hyphenatedCaseRef}\n ### ${applicant1LastName} and ${applicant2LastName}\n",
        access = {ApplicantAccess.class, CaseworkerCaaAccess.class}
    )
    Open,

    @CCD(
        label = "Closed case",
        hint = "### Case number: ${hyphenatedCaseRef}\n ### ${applicant1LastName} and ${applicant2LastName}\n",
        access = {ApplicantAccess.class, CaseworkerCaaAccess.class}
    )
    Closed;

}
