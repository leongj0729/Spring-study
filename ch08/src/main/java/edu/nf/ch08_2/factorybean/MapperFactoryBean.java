package edu.nf.ch08_2.factorybean;

import edu.nf.ch08_2.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author LJJ
 * @date 2020/12/2
 * 通过自定义FactoryBean来创建mybatis的mapper接口的代理对象
 * 这里的T表示任意Dao接口的类型
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    /**
     * JDK动态代理创建代理对象时需要传入一个接口
     * 而这个接口可以通过set方法注入进来
     */
    private Class<T> daoInterface;

    /**
     * 提供一个set方法注入一个Dao接口的Class对象
     * @param daoInterface
     */
    public void setDaoInterface(Class<T> daoInterface){
        this.daoInterface = daoInterface;
    }

    /**
     * 当IOC容器自动调用getObject方法时，返回的时sqlSession的getMapper
     * 的代理对象，这个代理对象就可以自动纳入容器中管理
     * @return
     * @throws Exception
     */
    @Override
    public T getObject() throws Exception {
        //创建连接数据库的类
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //getMapper生成代理对象，doInterface就是某个Dao接口的Class对象
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