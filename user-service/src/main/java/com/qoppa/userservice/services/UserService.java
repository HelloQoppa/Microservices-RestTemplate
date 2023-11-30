package com.qoppa.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.qoppa.userservice.dtos.DepartmentDTO;
import com.qoppa.userservice.dtos.ResponseDTO;
import com.qoppa.userservice.dtos.UserDTO;
import com.qoppa.userservice.interfaces.IUser;
import com.qoppa.userservice.models.User;
import com.qoppa.userservice.repositories.UserRepository;

@Service
public class UserService implements IUser {

    @Autowired
    private UserRepository userRepository;

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDTO getUser(Long userId) {
        ResponseDTO responseDto = new ResponseDTO();
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            UserDTO userDto = mapToUser(user);

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:8080/api/")
                    .path(String.valueOf(user.getDepartmentId()));

            ResponseEntity<DepartmentDTO> responseEntity = restTemplate
                    .getForEntity(builder.toUriString(), DepartmentDTO.class);

            DepartmentDTO departmentDto = responseEntity.getBody();

            System.out.println(responseEntity.getStatusCode());

            responseDto.setUser(userDto);
            responseDto.setDepartment(departmentDto);
        }

        return responseDto;
    }

    private UserDTO mapToUser(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
