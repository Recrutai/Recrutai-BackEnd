package com.recrutai.api.vacancy.interview;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interviews")
@Tag(name = "Interviews")
public class InterviewController {
    private final InterviewService interviewService;
    private final InterviewMapper interviewMapper;

    InterviewController(InterviewService interviewService, InterviewMapper interviewMapper) {
        this.interviewService = interviewService;
        this.interviewMapper = interviewMapper;
    }

    @Operation(summary = "Create a new interview")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content),
            @ApiResponse(responseCode = "422", description = "Validation failed", content = @Content)
    })
    @PostMapping
    ResponseEntity<InterviewResponse> create(@RequestBody @Valid InterviewRequest request) {
        var interview = interviewMapper.mapToResponse(interviewService.create(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(interview);
    }

    @Operation(summary = "Find all interviews for candidate")
    @GetMapping("/{id}")
    ResponseEntity<List<InterviewResponse>> findAllByCandidate(@PathVariable("id") long id) {
        var interviews = interviewService.findAllByCandidate(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(interviews);
    }

}
