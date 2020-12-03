package edu.nf.ch08_2.factorybean;

import edu.nf.ch08_2.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author LJJ
 * @date 2020/12/2
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> daoInterface;

    public void setDaoInterface(Class<T> daoInterface) {
        this.daoInterface = daoInterface;
    }

    @Override
    public T getObject() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        T mapperProxy = sqlSession.getMapper(daoInterface);
        return mapperProxy;
    }

    @Override
    public Class<?> getObjectType() {
        return daoInterface;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}