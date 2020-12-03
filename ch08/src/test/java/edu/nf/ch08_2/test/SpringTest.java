package edu.nf.ch08_2.test;

import edu.nf.ch08_2.entity.Users;
import edu.nf.ch08_2.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author LJJ
 * @date 2020/12/2
 */
public class SpringTest {

    @Test
    public void testFactoryBean(){
        //初始化容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //此时从容器获取的Bean就是一个mapper
        UserService service = context.getBean("userService", UserService.class);
        List<Users> list = service.listUser();
        list.forEach(user -> System.out.println(user.getUserName()));
    }
}