package com.bjpowernode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjpowernode.beans.Student;

/**
 * @Controller：创建处理器对象，默认是单例对象
 *    位置：类的上面
 *    
 * @RequestMapping:
 *       value: 指定请求uri的公共部分， 叫做模块名称。
 *              对请求地址统一管理。
 */
@Controller
@RequestMapping("user")
public class MyController {
	//定义方法，处理请求。 在处理器类中定义的方法叫做处理器方法。
	


	/**
	 * 处理器方法返回对象--List<Student>
	 * List<Student>表示数据，不是视图。
	 * 
	 * @ResponseBody:把处理后的数据，通过应答对象输出到浏览器。
	 * 
	 * 框架对象返回值是对象的处理步骤：
	 * 1.框架根据返回值的数据类型（Student），遍历寻找能够处理返回值的HttpMessageConverter接口的实现类对象。
	 *   Student - MappingJackson2HttpMessageConverter
	 * 2.使用HttpMessageConverter接口的实现类对象，处理返回值的数据。
	 *   是调用MappingJackson2HttpMessageConverter ， 使用application/json，对数据编码默认是 UTF-8.
	 *   得到是 JSONOArray
	 * 3.通过@ResponseBody,把2中的数据，通过HttpServletResponse对象，输出到应答体（浏览器）
	 */
	@RequestMapping(value="myajax.do") 
	@ResponseBody
	public List<Student> doSome() {
		System.out.println("doSome:");
		Student student = new Student();
		student.setAge(20);
		student.setName("李四同学");
		
		Student student2 = new Student();
		student2.setAge(28);
		student2.setName("张三同学");
		
		List<Student> students= new ArrayList<>();
		students.add(student2);//张三
		students.add(student);//李四
		return students; //数据
	}
	
}
