package com.example.SpringBoot_project_2.repository;

import com.example.SpringBoot_project_2.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

}
