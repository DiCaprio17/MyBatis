package com.test;

import com.dao.IUserDao;
import com.domain.User;
import com.mybaitis.io.Resources;
import com.mybaitis.sqlsession.SqlSession;
import com.mybaitis.sqlsession.SqlSessionFactory;
import com.mybaitis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂 创建工厂mybatis使用了构建者模式 把对象的创建细节隐藏，
        // 使使用者直接调用方法即可拿到对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象  生产SqlSession使用了工厂模式 解耦（降低类之间的依赖关系）
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象  创建DAO接口实现类使用了代理模式 不修改源码的基础上对已有方法增强
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
