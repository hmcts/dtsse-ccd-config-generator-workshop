package uk.gov.hmcts.demo.ccd;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import uk.gov.hmcts.ccd.sdk.api.HasRole;

@AllArgsConstructor
@Getter
public enum UserRole implements HasRole {
    CASE_WORKER("caseworker-demo", "CRU"),
    CASE_WORKER_CAA("caseworker-caa", "CRU"),
    SOLICITOR("caseworker-demo-solicitor", "CRU"),
    APPLICANT_1_SOLICITOR("[APPONESOLICITOR]", "CRU"),
    APPLICANT_2_SOLICITOR("[APPTWOSOLICITOR]", "CRU"),
    CITIZEN("citizen", "CRU"),
    CREATOR("[CREATOR]", "CRU");

    @JsonValue
    private final String role;
    private final String caseTypePermissions;

    public static UserRole fromString(String value) {
        for (UserRole role : UserRole.values()) {
            if (role.getRole().equals(value)) {
                return role;
            }
        }
        return null;
    }

}
