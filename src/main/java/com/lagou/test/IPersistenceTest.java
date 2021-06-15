package com.lagou.test;

import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shurenjie21167
 * @date 2021-03-11 21:07
 * @description:
 * @version: 1.0
 */
public class IPersistenceTest {
    @Test
    public void Test() throws PropertyVetoException, DocumentException, SQLException, IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, InvocationTargetException, ClassNotFoundException {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("舒仁杰");
        //测试修改
        //测试第二次修改
        //测试第三次修改
        //User userSelectOne = sqlSession.selectOne("user.selectOne", user);
        //System.out.println(userSelectOne);
        List<User> userAll = sqlSession.selectList("user.selectList");
        for (User user1:userAll) {
            System.out.println(user1);
        }
    }
}
