package uk.gov.hmcts.demo.ccd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.hmcts.ccd.sdk.api.CCD;
import uk.gov.hmcts.ccd.sdk.type.Document;
import uk.gov.hmcts.ccd.sdk.type.ListValue;
import uk.gov.hmcts.demo.ccd.access.ApplicantAccess;

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

//    private String applicant1FirstName;
//
//    private String applicant1LastName;
//
//    @CCD(label = "First Name", access = {ApplicantAccess.class})
//    private String applicant2FirstName;
//
//    @CCD(label = "Last Name", hint = "Enter their surname", access = {ApplicantAccess.class})
//    private String applicant2LastName;

    @JsonUnwrapped(prefix = "applicant1")
    private Applicant applicant1;

    @JsonUnwrapped(prefix = "applicant2")
    @CCD(access = {ApplicantAccess.class})
    private Applicant applicant2;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @CCD(typeOverride = Collection, typeParameterOverride = "Document")
    private List<ListValue<Document>> documents;

    private Complaint complaint;
}
