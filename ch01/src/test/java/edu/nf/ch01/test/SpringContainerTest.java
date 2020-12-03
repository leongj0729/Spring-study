package edu.nf.ch01.test;

import edu.nf.ch01.People;
import edu.nf.ch01.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LJJ
 * @date 2020/11/30
 * 在spring的框架中工厂分为两种，
 * 一种是BeanFaction，另一种是ApplicationContext
 * 简单点说，BeanFaction是Spring最基础的bean工厂，
 * 而ApplicationContext针对BeanFaction做了很多的功能扩展和增强
 * 官方也推荐我们使用ApplicationContext这个接口开操作Spring容器
 */
public class SpringContainerTest {

    @Test
    public void testGetBean(){
        //初始化spring容器（也就是一个容器工厂）
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //从容器中获取bean对象，根据id来获取
        //Users user = (Users) context.getBean("user");
        //使用泛型来获取
        Users user = context.getBean("user",Users.class);
        user.say();

        People people = context.getBean("people",People.class);
        people.run();
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Users users = context.getBean("user1",Users.class);
        users.say();
    }
}