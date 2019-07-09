package com.mybaitis.sqlsession.defaults;

import com.mybaitis.cfg.Configuration;
import com.mybaitis.sqlsession.SqlSession;
import com.mybaitis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     *
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
