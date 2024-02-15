package com.jw.prj.user.model.dao;


import com.jw.prj.user.model.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUser(User insertUser);


}
