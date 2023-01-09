package uk.gov.hmcts.demo.ccd.access;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import uk.gov.hmcts.ccd.sdk.api.HasAccessControl;
import uk.gov.hmcts.ccd.sdk.api.HasRole;
import uk.gov.hmcts.ccd.sdk.api.Permission;

import static java.util.List.of;
import static uk.gov.hmcts.ccd.sdk.api.Permission.CRU;
import static uk.gov.hmcts.ccd.sdk.api.Permission.R;
import static uk.gov.hmcts.demo.ccd.UserRole.CASE_WORKER;
import static uk.gov.hmcts.demo.ccd.UserRole.CITIZEN;
import static uk.gov.hmcts.demo.ccd.UserRole.SOLICITOR;

public class ApplicantAccess implements HasAccessControl {
    @Override
    public SetMultimap<HasRole, Permission> getGrants() {
        SetMultimap<HasRole, Permission> grants = HashMultimap.create();
        grants.putAll(CITIZEN, CRU);
        grants.putAll(SOLICITOR, CRU);
        grants.putAll(CASE_WORKER, of(R));
        return grants;
    }
}
