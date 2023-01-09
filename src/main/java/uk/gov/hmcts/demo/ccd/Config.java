package uk.gov.hmcts.demo.ccd;

import org.springframework.stereotype.Component;
import uk.gov.hmcts.ccd.sdk.api.CCDConfig;
import uk.gov.hmcts.ccd.sdk.api.ConfigBuilder;

@Component
public class Config implements CCDConfig<CaseData, State, UserRole> {

    @Override
    public void configure(ConfigBuilder<CaseData, State, UserRole> builder) {
        builder.caseType("demo", "My Case Type", "Case type description");
        builder.jurisdiction("demo-jurisdiction", "Jurisdiction", "Jurisdiction description");
        builder.setCallbackHost(System.getenv().getOrDefault("API_URL", "http://localhost:4013"));
    }

}
