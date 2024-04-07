package com.user.microservice.usermicroservice.service;

import com.user.microservice.usermicroservice.dtos.EmailRequestDTO;
import com.user.microservice.usermicroservice.dtos.register.RegisterRequestDTO;
import com.user.microservice.usermicroservice.dtos.register.RegisterResponseDTO;
import com.user.microservice.usermicroservice.model.UserModel;
import com.user.microservice.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public RegisterResponseDTO register(RegisterRequestDTO dto) throws Exception {
        if(userRepository.findByEmail(dto.email()) != null) throw new Exception();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var newUser = new UserModel(dto);
        newUser.setPassword(encoder.encode(dto.password()));
        userRepository.save(newUser);

        sendEmailWhenRegister(newUser.getEmail());

        return new RegisterResponseDTO(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail());
    }

    public void sendEmailWhenRegister(String to){
        var emailRequest = new EmailRequestDTO("manager-web", "webmanager094@gmail.com", to, "You have been registered successfully", "You were registered successfully, manager-web thanks your collaboration");
        emailService.sendEmail(emailRequest);
    }
}
