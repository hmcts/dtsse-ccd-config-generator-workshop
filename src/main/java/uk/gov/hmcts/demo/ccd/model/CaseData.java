package uk.gov.hmcts.demo.ccd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.hmcts.ccd.sdk.api.CCD;
import uk.gov.hmcts.ccd.sdk.type.Document;
import uk.gov.hmcts.ccd.sdk.type.ListValue;

import java.time.LocalDate;
import java.util.List;

import static uk.gov.hmcts.ccd.sdk.type.FieldType.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CaseData {

    private String hyphenatedCaseRef;

    private String applicant1FirstName;

    private String applicant1LastName;

    @CCD(label = "First Name")
    private String applicant2FirstName;

    @CCD(label = "Last Name", hint = "Enter their surname")
    private String applicant2LastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @CCD(typeOverride = Collection, typeParameterOverride = "Document")
    private List<ListValue<Document>> documents;

    private Complaint complaint;
}
