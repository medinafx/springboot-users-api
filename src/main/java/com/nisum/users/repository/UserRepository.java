package com.nisum.users.repository;

import com.nisum.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    @Query("select u from User u order by u.id asc")
    List<User> findAll();

    @Query("select u from User u where u.id = :id")
    Optional<User> findById(@Param("id") Integer id);

    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
