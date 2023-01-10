package uk.gov.hmcts.demo.ccd.search;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.ccd.sdk.api.CCDConfig;
import uk.gov.hmcts.ccd.sdk.api.ConfigBuilder;
import uk.gov.hmcts.ccd.sdk.api.SearchField;
import uk.gov.hmcts.demo.ccd.State;
import uk.gov.hmcts.demo.ccd.UserRole;
import uk.gov.hmcts.demo.ccd.model.CaseData;

import java.util.List;

import static java.util.List.of;
import static uk.gov.hmcts.ccd.sdk.api.SortOrder.FIRST;

@Component
public class SearchFields implements CCDConfig<CaseData, State, UserRole> {

    public static final List<SearchField<UserRole>> FIELDS = of(
        SearchField.<UserRole>builder().id("[CCD_REFERENCE]").label("Case Number").build(),
        SearchField.<UserRole>builder().id("applicant1FirstName").label("Applicant's First Name").build(),
        SearchField.<UserRole>builder().id("applicant1LastName").label("Applicant's Last Name").build(),
        SearchField.<UserRole>builder().id("dueDate").label("Due Date").build(),
        SearchField.<UserRole>builder().id("[LAST_STATE_MODIFIED_DATE]").label("Last state modified date").order(FIRST.ASCENDING).build()
    );

    @Override
    public void configure(final ConfigBuilder<CaseData, State, UserRole> builder) {
        builder.searchInputFields().fields(FIELDS);
        builder.searchResultFields().fields(FIELDS);
        builder.workBasketInputFields().fields(FIELDS);
        builder.workBasketResultFields().fields(FIELDS);
    }
}
