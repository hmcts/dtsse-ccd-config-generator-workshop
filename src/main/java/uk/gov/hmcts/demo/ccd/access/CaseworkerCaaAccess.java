package uk.gov.hmcts.demo.ccd.access;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import uk.gov.hmcts.ccd.sdk.api.HasAccessControl;
import uk.gov.hmcts.ccd.sdk.api.HasRole;
import uk.gov.hmcts.ccd.sdk.api.Permission;

import static java.util.List.of;
import static uk.gov.hmcts.ccd.sdk.api.Permission.R;
import static uk.gov.hmcts.demo.ccd.UserRole.CASE_WORKER_CAA;

public class CaseworkerCaaAccess implements HasAccessControl {
    @Override
    public SetMultimap<HasRole, Permission> getGrants() {
        SetMultimap<HasRole, Permission> grants = HashMultimap.create();
        grants.putAll(CASE_WORKER_CAA, of(R));
        return grants;
    }
}
