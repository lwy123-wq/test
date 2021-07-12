package com.dao;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    @Query(value = "select * from  user where username=:username and password=:password",nativeQuery = true)
    User findByNameAndPassword(@Param("username")String username, @Param("password")String password);
    //@Query(value = "insert into user(username, password) values(username=:username and password=:password)",nativeQuery = true;)
    String create(User u);

}
