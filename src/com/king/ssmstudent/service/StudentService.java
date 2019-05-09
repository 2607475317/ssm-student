package com.king.ssmstudent.service;

import com.king.ssmstudent.pojo.Student;

import java.util.List;

public interface StudentService {
    public List<Student> queryAll();
    public void delete(Student stu);
    public void save(Student stu);
    public Student queryOne(Student stu);
    public void update(Student stu);
    public Student login(Student stu);
}
