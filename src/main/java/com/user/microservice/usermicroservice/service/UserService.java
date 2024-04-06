package com.user.microservice.usermicroservice.service;

import com.user.microservice.usermicroservice.dtos.register.RegisterRequestDTO;
import com.user.microservice.usermicroservice.dtos.register.RegisterResponseDTO;
import com.user.microservice.usermicroservice.model.UserModel;
import com.user.microservice.usermicroservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisterResponseDTO register(RegisterRequestDTO dto) throws Exception {
        if(userRepository.findByEmail(dto.email()) != null) throw new Exception();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var newUser = new UserModel(dto);
        newUser.setPassword(encoder.encode(dto.password()));
        userRepository.save(newUser);

        return new RegisterResponseDTO(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail());
    }
}
