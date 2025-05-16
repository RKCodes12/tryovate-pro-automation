package com.tryovate.controller;

import com.tryovate.constants.CandidateConstants;
import com.tryovate.dto.CandidateDto;
import com.tryovate.dto.ResponseDto;
import com.tryovate.model.Candidate;
import com.tryovate.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/candidate-api")
@RestController()
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping(value = "/add-candidate",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CandidateDto candidateDto) {
        candidateService.saveCandidateDto(candidateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CandidateConstants.STATUS_201, CandidateConstants.MESSAGE_201));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CandidateDto> getCandidateById(@PathVariable String id) {
        CandidateDto candidateDto = candidateService.getCandidateById(id);
        return ResponseEntity.ok(candidateDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CandidateDto>> getAllCandidates() {
        List<CandidateDto> candidateDto = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidateDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteCandidate(@PathVariable String id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(CandidateConstants.STATUS_200, "Candidate deleted successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CandidateDto> updateCandidate(@PathVariable String id, @RequestBody CandidateDto candidateDto) {
        CandidateDto updatedCandidate = candidateService.updateCandidate(id, candidateDto);
        return ResponseEntity.ok(updatedCandidate);
    }


}
