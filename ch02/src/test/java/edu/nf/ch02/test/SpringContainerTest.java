package edu.nf.ch02.test;

import edu.nf.ch02.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LJJ
 * @date 2020/11/30
 */
public class SpringContainerTest {

    @Test
    public void testBeanScope(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people",People.class);
        People people1 = context.getBean("people",People.class);
        //people.say();
    }
}