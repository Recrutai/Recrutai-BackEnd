package com.recrutai.api.vacancy;

import com.recrutai.api.institution.InstitutionSummaryResponse;
import com.recrutai.api.shared.CurrencyCode;
import com.recrutai.api.shared.EmploymentType;
import com.recrutai.api.shared.WorkModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.Instant;

@Getter
public class VacancySummaryResponse {
    @Schema(example = "1")
    private final long id;

    @Schema(implementation = InstitutionSummaryResponse.class)
    private final InstitutionSummaryResponse institution;

    @Schema(example = "Back End Developer")
    private final String title;

    @Schema(example = "FULL_TIME")
    private final EmploymentType employmentType;

    @Schema(example = "ON_SITE")
    private final WorkModel workModel;

    @Schema(example = "5700")
    private final int salary;

    @Schema(example = "USD")
    private final CurrencyCode currencyCode;

    @Schema(example = "Oxford, Oxfordshire")
    private final String location;

    private final Instant publishedAt;

    public VacancySummaryResponse(
            long id,
            String title,
            EmploymentType employmentType,
            WorkModel workModel,
            int salary,
            CurrencyCode currencyCode,
            Instant publishedAt,
            long institutionId,
            String institutionName,
            String location
    ) {
        this.id = id;
        this.title = title;
        this.employmentType = employmentType;
        this.salary = salary;
        this.currencyCode = currencyCode;
        this.location = location;
        this.workModel = workModel;
        this.publishedAt = publishedAt;
        this.institution = new InstitutionSummaryResponse(institutionId, institutionName, null, null, null);
    }

}
