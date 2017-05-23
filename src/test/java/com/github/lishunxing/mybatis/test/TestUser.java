package com.github.lishunxing.mybatis.test;

import com.github.lishunxing.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by admin on 2017/5/23.
 */
public class TestUser {

    private SqlSessionFactory sqlSessionFactory;


    @Before
    public void init() throws IOException {
        //加载mybatis配置文件
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
        //初始化sqlSessionFactory
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsReader);
    }

    public SqlSession getSqlSession(){
        //获取sqlSession对象
        return sqlSessionFactory.openSession();
    }

    @Test
    public void testUser(){
        //要调用的方法名字
        String statement="com.github.lishunxing.mybatis.dao.UserDao.getById";
        //获取返回值
        User user=getSqlSession().selectOne(statement,1);
        System.out.println(user);
    }

}
