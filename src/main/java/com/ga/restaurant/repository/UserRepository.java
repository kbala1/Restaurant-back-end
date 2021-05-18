package com.ga.restaurant.repository;

import com.ga.restaurant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByPhoneNo(String phoneNo);



}
