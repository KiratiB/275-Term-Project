package com.backend.netflix.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.netflix.vo.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
	List<User> findByEmailAndPassword(String email,String password);
	
	
	@Modifying
	@Transactional
	@Query(value="UPDATE users SET verified=true WHERE id=?1,",nativeQuery=true)
	public void setVerifiedToTrue(int id);

}
