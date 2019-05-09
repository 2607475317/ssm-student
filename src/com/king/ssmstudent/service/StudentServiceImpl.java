package com.king.ssmstudent.service;

import com.king.ssmstudent.mapper.StudentMapper;
import com.king.ssmstudent.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Student> queryAll() {
        return studentMapper.queryAll();
    }

    @Override
    public void delete(Student stu) {
         studentMapper.delete(stu);
    }

    @Override
    public void save(Student stu) {
        studentMapper.save(stu);
    }

    @Override
    public Student queryOne(Student stu) {
        return studentMapper.queryOne(stu);
    }

    @Override
    public void update(Student stu) {
        studentMapper.update(stu);
    }

    @Override
    public Student login(Student stu) {
        return studentMapper.login(stu);
    }


}
