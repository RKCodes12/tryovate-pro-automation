package com.tryovate.repository;

import com.tryovate.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, String> {

     Optional<Candidate> findByEmail(String email);


     @Query("SELECT c.id FROM Candidate c WHERE c.id LIKE :prefix% ORDER BY c.id DESC LIMIT 1")
     String findLatestIdForMonth(String prefix);
}

