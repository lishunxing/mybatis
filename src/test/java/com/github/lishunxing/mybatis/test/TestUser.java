package com.github.lishunxing.mybatis.test;

import com.github.lishunxing.mybatis.dao.UserDao;
import com.github.lishunxing.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by admin on 2017/5/23.
 */
public class TestUser {

    private SqlSession sqlSession;


    @Before
    public void init() throws IOException {
        //加载mybatis配置文件
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
        //初始化sqlSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsReader);
        sqlSession=sqlSessionFactory.openSession(true);
    }

    @After
    public void destroy(){
        sqlSession.close();
    }

    @Test
    public void testAnnoationSelect(){
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        User user=userDao.getById(1L);
        System.out.println("result ==>"+user.toString());
    }

    @Test
    public void testDeleteUser(){
        String statement="com.github.lishunxing.mybatis.dao.UserDao.delete";

        int result=sqlSession.delete(statement,4);
        System.out.println("result ==>"+result);
    }

    @Test
    public void testUpdateUser(){
        String statement="com.github.lishunxing.mybatis.dao.UserDao.update";

        User user=new User();
        user.setId(4L);
        user.setName("沈千未111");
        user.setAge(24);

        int result=sqlSession.update(statement,user);
        System.out.println("result ==>"+result);
        System.out.println(user);
    }

    @Test
    public void testCreateUser(){
        String statement="com.github.lishunxing.mybatis.dao.UserDao.save";

        User user=new User();
        //user.setName("沈千未");
        user.setName("吃屎莫");
        user.setAge(24);

        int result=sqlSession.insert(statement,user);
        System.out.println("result ==>"+result);
        System.out.println(user);
    }

    @Test
    public void testGetUser(){
        //要调用的方法名字
        String statement="com.github.lishunxing.mybatis.dao.UserDao.getById";
        //获取返回值
        User user=sqlSession.selectOne(statement,1);
        System.out.println(user);
    }

}
