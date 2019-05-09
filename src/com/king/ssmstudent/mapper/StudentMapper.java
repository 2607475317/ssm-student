package com.king.ssmstudent.mapper;

import com.king.ssmstudent.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有数据
    public List<Student> queryAll();
    //删除方法
    public void delete(Student stu);
    //增加保存数据的方法
    public void save(Student stu);
    //修改的数据回显  一条数据
    public Student queryOne(Student stu);
    //修改数据的保存
    public void update(Student stu);
    //登录方法
    public Student login(Student stu);

}
