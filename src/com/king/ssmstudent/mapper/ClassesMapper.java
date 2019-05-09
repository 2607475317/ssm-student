package com.king.ssmstudent.mapper;

import com.king.ssmstudent.pojo.Classes;
import com.king.ssmstudent.pojo.ClassesChart;

import java.util.List;

public interface ClassesMapper {
    //查询班级的方法
    public List<Classes> queryAll();
    //查询报表的方法
    public List<ClassesChart> queryClassesChart();

}
