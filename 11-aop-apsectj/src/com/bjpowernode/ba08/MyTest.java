package com.bjpowernode.ba08;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba08/applicationContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		
		//从spring获取aspectj修改的目标对象，就是代理对象
		SomeService service  = (SomeService) ctx.getBean("someServiceTarget");
		System.out.println("service:"+service.getClass().getName());

		service.doThird();
		
	}
	
	
}
