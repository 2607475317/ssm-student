package com.king.ssmstudent.test;


import com.king.ssmstudent.mapper.StudentMapper;
import com.king.ssmstudent.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
//使用junit4进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//引入多个配置文件
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class TestMybatis {
    @Autowired
    StudentMapper studentMapper;
    @Test
    public void testMybatis() throws Exception{
        List<Student> list = studentMapper.queryAll();
        for (Student a:list
             ) {
            System.out.println(a);
        }
    }
}
