package uk.gov.hmcts.demo.ccd;

import uk.gov.hmcts.ccd.sdk.api.CCD;

public enum State {

    @CCD(
        label = "Open case",
        hint = "### Case number: ${hyphenatedCaseRef}\n ### ${applicant1LastName} and ${applicant2LastName}\n"
    )
    Open,

    @CCD(
        label = "Closed case",
        hint = "### Case number: ${hyphenatedCaseRef}\n ### ${applicant1LastName} and ${applicant2LastName}\n"
    )
    Closed;

}
