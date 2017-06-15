package com.github.lishunxing.mybatis.dao;

import com.github.lishunxing.mybatis.entity.Role;
import org.apache.ibatis.annotations.*;

/**
 * Created by admin on 2017/5/24.
 */
public interface RoleDao {

    @Select("select * from role where Id = #{id}")
    Role getById();

    @Options(useGeneratedKeys = true,keyProperty = "role.id")
    @Insert("insert into role(`name`) values(#{role.name})")
    int save(@Param("role") Role role);

    @Update("update role set name = #{role.name} where id = #{role.id}")
    int update(@Param("role") Role role);

    @Delete("delete from role where id = #{id}")
    int delete(@Param("id")Long id);

}
