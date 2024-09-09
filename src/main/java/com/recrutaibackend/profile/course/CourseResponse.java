package com.recrutaibackend.profile.course;

import com.recrutaibackend.institution.SimpleInstitutionResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.YearMonth;

public record CourseResponse(
        @Schema(example = "1")
        long id,

        @Schema(implementation = SimpleInstitutionResponse.class)
        SimpleInstitutionResponse school,

        @Schema(example = "Back End Development Summer Course")
        String name,

        @Schema(example = "240")
        int workloadHours,

        @Schema(example = "2024-09")
        YearMonth completionDate,

        @Schema(example = "Course about programming and back end development focused on the development of APIs.")
        String description
) {
}
