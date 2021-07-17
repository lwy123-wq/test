package com.dao;

import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

/*public interface UserDao extends JpaRepository<User,Integer> {
    @Query(value = "select * from  user where username=:username and password=:password",nativeQuery = true)
    User findByNameAndPassword( String username, String password);
    //@Query(value = "insert into user(username, password) values(username=:username and password=:password)",nativeQuery = true;)
    //String create(User u);

}*/
@Component
public class UserDao implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(String username,String password) {
        return jdbcTemplate.update("insert into user(username,password)values (?,?)",username,password);
    }

    public User findByName(String name) {
        final User user = new User();
        String sql = "SELECT username FROM t_user_1 WHERE name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                //user.setId(resultSet.getString(1));
                user.setUsername(resultSet.getString(1));
            }
        });
        return user;
    }
}