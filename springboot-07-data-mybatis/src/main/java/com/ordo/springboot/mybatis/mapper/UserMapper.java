package com.ordo.springboot.mybatis.mapper;

import com.ordo.springboot.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
//Marker interface for MyBatis mappers
@Repository
//Teams implementing traditional Java EE patterns such as "Data Access Object"
// may also apply this stereotype to DAO classes
public interface UserMapper {
    List<User> selectUser();

    User selectUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);


}
