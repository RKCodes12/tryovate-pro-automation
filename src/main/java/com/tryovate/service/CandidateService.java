package com.tryovate.service;

import com.tryovate.dto.CandidateDto;

import java.util.List;

public interface CandidateService {

    void saveCandidateDto(CandidateDto candidateDto);

    String generateCandidateId();

    CandidateDto getCandidateById(String id);

    List<CandidateDto> getAllCandidates();

    CandidateDto updateCandidate(String id, CandidateDto candidateDto);

    void deleteCandidate(String id);
}
