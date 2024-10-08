package com.recrutai.api.auth.verification;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long> {

    @EntityGraph(attributePaths = {"user"})
    Optional<EmailVerification> findWithUserByCode(String code);

}
