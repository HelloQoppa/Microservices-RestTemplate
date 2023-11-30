package com.qoppa.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.userservice.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
