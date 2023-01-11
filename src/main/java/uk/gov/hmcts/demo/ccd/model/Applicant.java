package uk.gov.hmcts.demo.ccd.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import uk.gov.hmcts.ccd.sdk.type.AddressUK;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Applicant {

    private String firstName;

    private String lastName;

    private AddressUK address;

}
