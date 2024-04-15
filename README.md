# User API

## Description
This program aims to be a user manage, where an user can do login and sign-up. When a user does a register, the program send a congratulations email using my own email microservice. 

## Technologies
- Java
- Spring boot
- Spring security
- MySQL
- Feign
- docker

## Database Schema 
```
CREATE TABLE IF NOT EXISTS `users` (
    `id` CHAR(36) NOT NULL,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL UNIQUE, 
    `password` VARCHAR(255) NOT NULL,
    `role` ENUM('ADMIN', 'USER') NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

