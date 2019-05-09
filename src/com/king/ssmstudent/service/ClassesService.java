package com.king.ssmstudent.service;

import java.util.List;

import com.king.ssmstudent.pojo.Classes;
import com.king.ssmstudent.pojo.ClassesChart;


public interface ClassesService {
	
	public List<Classes> queryAll();

	//查询报表的方法
	public List<ClassesChart> queryClassesChart();
	
	

}
