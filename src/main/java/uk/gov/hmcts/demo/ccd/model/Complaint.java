package uk.gov.hmcts.demo.ccd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import uk.gov.hmcts.ccd.sdk.api.CCD;

import java.time.LocalDateTime;

import static uk.gov.hmcts.ccd.sdk.type.FieldType.TextArea;

public class Complaint {

    @CCD(typeOverride = TextArea)
    private String complaint;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime date;

}
