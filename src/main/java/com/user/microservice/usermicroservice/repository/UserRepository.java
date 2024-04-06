package com.user.microservice.usermicroservice.repository;

import com.user.microservice.usermicroservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
