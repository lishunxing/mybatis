package com.github.lishunxing.mybatis.test;

import com.github.lishunxing.mybatis.dao.RoleDao;
import com.github.lishunxing.mybatis.entity.Role;
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
 * Created by admin on 2017/6/15.
 */
public class TestRole {

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
    public void testAnnotationCreate(){
        Role role=new Role();
        role.setName("儿子");
        RoleDao roleDao=sqlSession.getMapper(RoleDao.class);
        roleDao.save(role);

        System.out.println("result ==>"+role);
    }

    @Test
    public void testAnnotationSelect(){
        RoleDao roleDao=sqlSession.getMapper(RoleDao.class);
    }

}
