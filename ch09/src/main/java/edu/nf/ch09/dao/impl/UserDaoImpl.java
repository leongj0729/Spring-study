package edu.nf.ch09.dao.impl;

import edu.nf.ch09.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author LJJ
 * @date 2020/12/3
 */
//@Component("userDao")
//可以使用@Repository注解来标识dao层
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("insert into user_info");
    }
}