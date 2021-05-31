package com.njtc.njvolunteer.mapper;

import com.njtc.njvolunteer.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(username,password,token) values (#{username},#{password},#{token})")
    void insertuser(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    User selectUser(User user);

    @Select("select  * from user where token=#{token}")
    User findBytoken(String token);

    @Select("select * from user where id=#{createid}")
    User findById(int createid);

}
