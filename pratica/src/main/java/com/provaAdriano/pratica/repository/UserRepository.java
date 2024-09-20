package com.provaAdriano.pratica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.provaAdriano.pratica.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
