package com.example.demo.repo;
import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{
	@Query
	UserEntity findByUserId(String userId);
}
