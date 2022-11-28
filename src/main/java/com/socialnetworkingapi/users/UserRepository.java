package com.socialnetworkingapi.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.fname = :fname")
    public List<User> getUserByFname(@Param("fname") String fname);

    @Query("select u from User u where u.lname = :lname")
    public List<User> getUserByLname(@Param("lname") String lname);
    
}
