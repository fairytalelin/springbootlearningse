package com.claylin.dao;

import com.claylin.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by claylin on 2017/5/10.
 */
@Mapper
public interface UserDao {
    User findByName(@Param("userName") String userName);
}
