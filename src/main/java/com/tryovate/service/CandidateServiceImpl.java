package com.tryovate.service;

import com.tryovate.dto.CandidateDto;
import com.tryovate.exception.CandidateAlreadyExistsException;
import com.tryovate.exception.CandidateNotFoundException;
import com.tryovate.exception.NoCandidatesFoundException;
import com.tryovate.mapper.CandidateMapper;
import com.tryovate.model.Candidate;
import com.tryovate.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;


    @Override
    public void saveCandidateDto(CandidateDto candidateDto) {

            Optional<Candidate> existingCandidate = candidateRepo.findByEmail(candidateDto.getEmail());
            if(existingCandidate.isPresent()) {
                throw new CandidateAlreadyExistsException("email already exist "
                        +candidateDto.getEmail());
            }


        Candidate candidate = CandidateMapper.mapToCandidate(candidateDto,new Candidate());
        candidate.setId(generateCandidateId()); // your existing ID generator
        candidateRepo.save(candidate);
    }

    @Override
    public String generateCandidateId() {
        LocalDate now = LocalDate.now();
        String year = String.valueOf(now.getYear()).substring(2); // "2025" → "25"
        String month = String.format("%02d", now.getMonthValue()); // "4" → "04"

        String prefix = year + month; // "2504"

        // Get the latest ID with this prefix
        String latestId = candidateRepo.findLatestIdForMonth(prefix);

        int nextSequence = 1;
        if (latestId != null) {
            int lastSequence = Integer.parseInt(latestId.substring(4)); // Extract "XXXX" part
            nextSequence = lastSequence + 1;
        }

        // Format sequence as 4 digits (0001, 0002, ...)
        return prefix + String.format("%04d", nextSequence);
    }


    @Override
    public CandidateDto getCandidateById(String id) {
        Candidate candidate = candidateRepo.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Given Id Not Found"));
        return CandidateMapper.mapToCandidateDto(candidate);
    }

    @Override
    public CandidateDto updateCandidate(String id, CandidateDto candidateDto) {
        Candidate candidate = candidateRepo.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Given Id Not Found"));

        candidate.setFullName(candidateDto.getFullName());
        candidate.setDob(candidateDto.getDob());
        candidate.setGender(candidateDto.getGender());
        candidate.setContactNumber(candidateDto.getContactNumber());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setCurrentAddress(candidateDto.getCurrentAddress());
        candidate.setPermanentAddress(candidateDto.getPermanentAddress());
        candidate.setMotherName(candidateDto.getMotherName());
        candidate.setFatherName(candidateDto.getFatherName());
        candidate.setAlternateNumber(candidateDto.getAlternateNumber());
        candidate.setAadharCard(candidateDto.getAadharCard());
        candidate.setPanCard(candidateDto.getPanCard());
        candidate.setReference(candidateDto.getReference());
        candidate.setDegree(candidateDto.getDegree());
        candidate.setUniversityCollegeName(candidateDto.getUniversityCollegeName());
        candidate.setYearOfPassing(candidateDto.getYearOfPassing());
        candidate.setSpecializationMajor(candidateDto.getSpecializationMajor());
        candidate.setPercentageCgpa(candidateDto.getPercentageCgpa());
        candidate.setHighestDegree(candidateDto.getHighestDegree());
        candidate.setPgUniversityCollegeName(candidateDto.getPgUniversityCollegeName());
        candidate.setPgYearOfPassing(candidateDto.getPgYearOfPassing());
        candidate.setPgSpecializationMajor(candidateDto.getPgSpecializationMajor());
        candidate.setPgPercentageCgpa(candidateDto.getPgPercentageCgpa());
        candidate.setLongMemo(candidateDto.getLongMemo());
        if (candidateDto.getSelectedCourse() != null && !candidateDto.getSelectedCourse().isEmpty()) {
            String courses = String.join(",", candidateDto.getSelectedCourse());
            candidate.setSelectedCourse(courses);
        } else {
            throw new IllegalArgumentException("Selected courses must not be null or empty");
        }


        candidate.setBatchId(candidateDto.getBatchId());
        candidate.setPaymentType(candidateDto.getPaymentType());
        candidate.setPaymentMode(candidateDto.getPaymentMode());
        candidate.setPartialPaidAmount(candidateDto.getPartialPaidAmount());
        candidate.setTotalPayableAmount(candidateDto.getTotalPayableAmount());
        candidate.setRemainingAmount(candidateDto.getRemainingAmount());

        Candidate updatedCandidate = candidateRepo.save(candidate);
        return CandidateMapper.mapToCandidateDto(updatedCandidate);
    }


    @Override
    public void deleteCandidate(String id) {
        Candidate candidate = candidateRepo.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found with ID: " + id));
        candidateRepo.delete(candidate);
    }


    @Override
    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepo.findAll();
        if (candidates.isEmpty()) {
            throw new NoCandidatesFoundException("No candidates available");
        }
        return candidates.stream()
                .map(CandidateMapper::mapToCandidateDto)
                .collect(Collectors.toList());
    }
    }
