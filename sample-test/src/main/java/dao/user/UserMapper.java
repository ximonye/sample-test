package dao.user;

import model.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{username} AND password=#{password}")
    User query(@Param("username")
               String userName, @Param("password")
               String password);
    @Select("SELECT * FROM users WHERE name = #{username}")
    User queryByUserName(@Param("username")
                         String userName);

    @Update("UPDATE users SET age = #{age} WHERE name = #{name}")
    int update(User user);

    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Delete("DELETE FROM users WHERE name = #{username}")
    int delete(@Param("username") String userName);

    @Insert("INSERT INTO users(name, password, age) VALUES(#{name}, #{password}, #{age})")
    int create(User user);
}
