package edu.nf.ch06.test;

import edu.nf.ch06.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LJJ
 * @date 2020/12/2
 */
public class SpringTest {

    @Test
    public void testInject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Users user = context.getBean("user",Users.class);
        System.out.println(user.getUserName());
        System.out.println(user.getAge());
        user.getAddress().forEach(addr -> System.out.println(addr));
        user.getCard().forEach((k,v) -> System.out.println(k+":"+v));
        System.out.println(user.getProp().getProperty("aa"));
        System.out.println(user.getProp().getProperty("bb"));
    }
}