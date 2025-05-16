package com.tryovate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data

@Entity
@Table(name = "Candidate")
public class Candidate {

    @Id
    private String id;

    @Column(name = "full Name")
    private String fullName;

    @Column(name = "DOB")
    private String dob;
    ;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Contact Number",unique = true, nullable = false)
    private String contactNumber;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "Current Address")
    private String currentAddress;

    @Column(name = "permanent Address")
    private String permanentAddress;

    @Column(name = "Mother Name")
    private String motherName;

    @Column(name = "Father Name")
    private String fatherName;

    @Column(name = "Alternate Number")
    private String alternateNumber;

    @Column(name = "Aadhar Card",unique = true, nullable = false)
    private String aadharCard;

    @Column(name = "Pan Card",unique = true, nullable = false)
    private String panCard;

    @Column(name = "Reference Name")
    private String reference;

    private String degree;

    private String universityCollegeName;

    private int yearOfPassing;

    private String specializationMajor;

    private String percentageCgpa;

    private String highestDegree;

    private String pgUniversityCollegeName;

    private int pgYearOfPassing;

    private String pgSpecializationMajor;

    private double pgPercentageCgpa;

    private String longMemo;

    private String selectedCourse;

    private String batchId;

    private String paymentType;

    private String paymentMode;

    private double partialPaidAmount;

    private double totalPayableAmount;

    private double remainingAmount;


    public Candidate() {
    }

    public Candidate(String aadharCard, String alternateNumber, String batchId, String contactNumber, String currentAddress, String degree, String dob, String email, String fatherName, String fullName, String gender, String highestDegree, String id, String longMemo, String motherName, String panCard, double partialPaidAmount, String paymentMode, String paymentType, String percentageCgpa, String permanentAddress, double pgPercentageCgpa, String pgSpecializationMajor, String pgUniversityCollegeName, int pgYearOfPassing, String reference, double remainingAmount, String selectedCourse, String specializationMajor, double totalPayableAmount, String universityCollegeName, int yearOfPassing) {
        this.aadharCard = aadharCard;
        this.alternateNumber = alternateNumber;
        this.batchId = batchId;
        this.contactNumber = contactNumber;
        this.currentAddress = currentAddress;
        this.degree = degree;
        this.dob = dob;
        this.email = email;
        this.fatherName = fatherName;
        this.fullName = fullName;
        this.gender = gender;
        this.highestDegree = highestDegree;
        this.id = id;
        this.longMemo = longMemo;
        this.motherName = motherName;
        this.panCard = panCard;
        this.partialPaidAmount = partialPaidAmount;
        this.paymentMode = paymentMode;
        this.paymentType = paymentType;
        this.percentageCgpa = percentageCgpa;
        this.permanentAddress = permanentAddress;
        this.pgPercentageCgpa = pgPercentageCgpa;
        this.pgSpecializationMajor = pgSpecializationMajor;
        this.pgUniversityCollegeName = pgUniversityCollegeName;
        this.pgYearOfPassing = pgYearOfPassing;
        this.reference = reference;
        this.remainingAmount = remainingAmount;
        this.selectedCourse = selectedCourse;
        this.specializationMajor = specializationMajor;
        this.totalPayableAmount = totalPayableAmount;
        this.universityCollegeName = universityCollegeName;
        this.yearOfPassing = yearOfPassing;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public String getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(String alternateNumber) {
        this.alternateNumber = alternateNumber;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongMemo() {
        return longMemo;
    }

    public void setLongMemo(String longMemo) {
        this.longMemo = longMemo;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public double getPartialPaidAmount() {
        return partialPaidAmount;
    }

    public void setPartialPaidAmount(double partialPaidAmount) {
        this.partialPaidAmount = partialPaidAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPercentageCgpa() {
        return percentageCgpa;
    }

    public void setPercentageCgpa(String percentageCgpa) {
        this.percentageCgpa = percentageCgpa;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public double getPgPercentageCgpa() {
        return pgPercentageCgpa;
    }

    public void setPgPercentageCgpa(double pgPercentageCgpa) {
        this.pgPercentageCgpa = pgPercentageCgpa;
    }

    public String getPgSpecializationMajor() {
        return pgSpecializationMajor;
    }

    public void setPgSpecializationMajor(String pgSpecializationMajor) {
        this.pgSpecializationMajor = pgSpecializationMajor;
    }

    public String getPgUniversityCollegeName() {
        return pgUniversityCollegeName;
    }

    public void setPgUniversityCollegeName(String pgUniversityCollegeName) {
        this.pgUniversityCollegeName = pgUniversityCollegeName;
    }

    public int getPgYearOfPassing() {
        return pgYearOfPassing;
    }

    public void setPgYearOfPassing(int pgYearOfPassing) {
        this.pgYearOfPassing = pgYearOfPassing;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public String getSpecializationMajor() {
        return specializationMajor;
    }

    public void setSpecializationMajor(String specializationMajor) {
        this.specializationMajor = specializationMajor;
    }

    public double getTotalPayableAmount() {
        return totalPayableAmount;
    }

    public void setTotalPayableAmount(double totalPayableAmount) {
        this.totalPayableAmount = totalPayableAmount;
    }

    public String getUniversityCollegeName() {
        return universityCollegeName;
    }

    public void setUniversityCollegeName(String universityCollegeName) {
        this.universityCollegeName = universityCollegeName;
    }
}