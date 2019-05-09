package com.king.ssmstudent.service;

import java.util.List;

import com.king.ssmstudent.mapper.ClassesMapper;
import com.king.ssmstudent.pojo.Classes;
import com.king.ssmstudent.pojo.ClassesChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassesServiceImpl implements ClassesService {

	
	@Autowired
	ClassesMapper mapper;


	@Override
	public List<Classes> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public List<ClassesChart> queryClassesChart() {
		return mapper.queryClassesChart();
	}


}
