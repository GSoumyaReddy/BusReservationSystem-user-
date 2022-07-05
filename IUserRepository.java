package com.cg.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{
	
	
}
