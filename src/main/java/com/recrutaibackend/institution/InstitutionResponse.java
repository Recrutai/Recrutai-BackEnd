package com.recrutaibackend.institution;

import com.recrutaibackend.address.AddressResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

public record InstitutionResponse(
        @Schema(example = "1")
        long id,

        @Schema(example = "University of Oxford")
        String name,

        @Schema(example = "PRIVATE")
        String type,

        @Schema(example = "The official University of Oxford Recrutaí page.")
        String headline,

        @Schema(example = "1")
        long founderId,

        @Schema(example = "Education")
        String industry,

        @Schema(example = "10.001+")
        String companySize,

        @Schema(example = "27450")
        int associatedEmployees,

        @Schema(implementation = AddressResponse.class)
        AddressResponse headquarters,

        @Schema(example = "www.ox.ac.uk")
        String website,

        @Schema(example = "Ranked number one in the world in the 2023 Times Higher Education World Rankings, we are at the forefront of the full range of academic disciplines, including medical sciences; mathematical, physical and life sciences; humanities; and social sciences. As the oldest university in the English-speaking world, we have long traditions of scholarship, but we are also forward-looking, creative and cutting-edge. Oxford is one of Europe's most entrepreneurial universities: we rank first in the UK for university spin-outs, with more than 130 companies created to date. We are also recognised as leaders in support for social enterprise.")
        String about,

        Instant createdAt
) {
}
