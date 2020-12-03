package edu.nf.ch05.test;

import edu.nf.ch05.entity.Users;
import edu.nf.ch05.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LJJ
 * @date 2020/12/1
 */
public class IocTest {

    @Test
    public void testContainer(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = context.getBean("userService", UserService.class);
        Users user = new Users();
        service.add(user);


    }
}