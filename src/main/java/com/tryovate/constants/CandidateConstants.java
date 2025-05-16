package com.tryovate.constants;

public class CandidateConstants {

    private CandidateConstants() {
        // restrict instantiation
    }
    public static final String  STATUS_201 = "201";
    public static final String  MESSAGE_201 = "Candidate Register successfully";

    public static final String  STATUS_200 = "200";
    public static final String  MESSAGE_200 = "Request processed successfully";

    public static final String STATUS_400 = "400";
    public static final String MESSAGE_400_VALIDATION = "Validation failed. Please check your input";

    public static final String STATUS_404 = "404";
    public static final String MESSAGE_CANDIDATE_NOT_FOUND = "Candidate not found";

    public static final String STATUS_409 = "409";
    public static final String MESSAGE_409_CONFLICT = "Duplicate entry for a unique field";

    public static final String  STATUS_500 = "500";
    public static final String  MESSAGE_500 = "An error occurred. Please try again or contact Dev team";



}
