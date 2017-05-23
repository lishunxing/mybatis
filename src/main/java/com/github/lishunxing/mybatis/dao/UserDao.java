package com.github.lishunxing.mybatis.dao;

import com.github.lishunxing.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/5/23.
 */
public interface UserDao {

    User getById(@Param("id")Long id);
}
