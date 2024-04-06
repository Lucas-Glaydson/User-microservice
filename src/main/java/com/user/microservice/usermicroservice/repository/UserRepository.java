package com.user.microservice.usermicroservice.repository;

import com.user.microservice.usermicroservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    UserDetails findByEmail(String email);
}
