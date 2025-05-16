package com.tryovate.mapper;

import com.tryovate.dto.CandidateDto;
import com.tryovate.model.Candidate;

import java.util.ArrayList;
import java.util.Arrays;

public class CandidateMapper {

    public static CandidateDto mapToCandidateDto(Candidate candidate) {
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(candidate.getId());
        candidateDto.setFullName(candidate.getFullName());
        candidateDto.setDob(candidate.getDob());
        candidateDto.setGender(candidate.getGender());
        candidateDto.setContactNumber(candidate.getContactNumber());
        candidateDto.setEmail(candidate.getEmail());
        candidateDto.setCurrentAddress(candidate.getCurrentAddress());
        candidateDto.setPermanentAddress(candidate.getPermanentAddress());
        candidateDto.setMotherName(candidate.getMotherName());
        candidateDto.setFatherName(candidate.getFatherName());
        candidateDto.setAlternateNumber(candidate.getAlternateNumber());
        candidateDto.setAadharCard(candidate.getAadharCard());
        candidateDto.setPanCard(candidate.getPanCard());
        candidateDto.setReference(candidate.getReference());
        candidateDto.setDegree(candidate.getDegree());
        candidateDto.setUniversityCollegeName(candidate.getUniversityCollegeName());
        candidateDto.setYearOfPassing(candidate.getYearOfPassing());
        candidateDto.setSpecializationMajor(candidate.getSpecializationMajor());
        candidateDto.setPercentageCgpa(candidate.getPercentageCgpa());
        candidateDto.setHighestDegree(candidate.getHighestDegree());
        candidateDto.setPgUniversityCollegeName(candidate.getPgUniversityCollegeName());
        candidateDto.setPgYearOfPassing(candidate.getPgYearOfPassing());
        candidateDto.setPgSpecializationMajor(candidate.getPgSpecializationMajor());
        candidateDto.setPgPercentageCgpa(candidate.getPgPercentageCgpa());
        candidateDto.setLongMemo(candidate.getLongMemo());

        // Convert comma-separated string back to list
        if (candidate.getSelectedCourse() != null && !candidate.getSelectedCourse().isEmpty()) {
            candidateDto.setSelectedCourse(Arrays.asList(candidate.getSelectedCourse().split(",")));
        }
    else {
        candidateDto.setSelectedCourse(new ArrayList<>());
    }
        candidateDto.setBatchId(candidate.getBatchId());
        candidateDto.setPaymentType(candidate.getPaymentType());
        candidateDto.setPaymentMode(candidate.getPaymentMode());
        candidateDto.setPartialPaidAmount(candidate.getPartialPaidAmount());
        candidateDto.setTotalPayableAmount(candidate.getTotalPayableAmount());
        candidateDto.setRemainingAmount(candidate.getRemainingAmount());

        return candidateDto;
    }

    public static Candidate mapToCandidate(CandidateDto candidateDto, Candidate candidate){
        candidate.setId(candidateDto.getId());
        candidate.setFullName(candidateDto.getFullName());                              // CourseRepo courseRepo  this is for logic
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

        // Convert list to comma-separated string
        if (candidateDto.getSelectedCourse() != null && !candidateDto.getSelectedCourse().isEmpty()) {
            candidate.setSelectedCourse(String.join(",", candidateDto.getSelectedCourse()));
        }
    else {
        candidate.setSelectedCourse("");
    }
        candidate.setBatchId(candidateDto.getBatchId());
        candidate.setPaymentType(candidateDto.getPaymentType());
        candidate.setPaymentMode(candidateDto.getPaymentMode());
        candidate.setPartialPaidAmount(candidateDto.getPartialPaidAmount());
        candidate.setTotalPayableAmount(candidateDto.getTotalPayableAmount());
        candidate.setRemainingAmount(candidateDto.getRemainingAmount());

        return candidate;

    }
}
