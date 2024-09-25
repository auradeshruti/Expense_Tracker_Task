package com.et.task.repository;

import com.et.task.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    //  can define custom query methods if needed
	 Users findByUsername(String username);

	boolean existsByUsername(String username);
}
