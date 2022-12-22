package com.glady.gladyTest.repository;

import com.glady.gladyTest.model.Company;
import com.glady.gladyTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
