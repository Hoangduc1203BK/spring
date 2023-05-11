package com.example.user.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.user.persistence.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String Email);
    @Query("SELECT p FROM user p WHERE (:email IS NULL OR p.email = :email) AND (:phoneNumber IS NULL OR p.phoneNumber = :phoneNumber)")
    Optional<User> findByEmailAndPhonenumber(@Param("email") String email, @Param("phoneNumber")  String phoneNumber);
    Page<User> findAll(Pageable pageable);
}
