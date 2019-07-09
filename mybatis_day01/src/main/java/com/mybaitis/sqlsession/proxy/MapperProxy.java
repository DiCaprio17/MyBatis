package com.mybaitis.sqlsession.proxy;

import com.mybaitis.cfg.Mapper;
import com.mybaitis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    //map的key是全限定类名+方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法进行增强的，我们的增强其实就是调用selectList方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methdodName = method.getName();
        //2.获取方法所在声明类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className+"."+methdodName;
        //4.获取mappers中Mapeer对象
        Mapper mapper = mappers.get(key);
        //5.判断是否有mapper
        if (mapper == null) {
            throw new IllegalArgumentException("传入参数有误");
        }
        //6.调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
