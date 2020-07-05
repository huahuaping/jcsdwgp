package com.wgp.service.impl;

import com.wgp.entity.Course;
import com.wgp.entity.Course;
import com.wgp.mapper.CourseMapper;
import com.wgp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    public int deleteByPrimaryKey(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public int insertSelective(Course course) {
        return courseMapper.insertSelective(course);
    }

    @Override
    public Course selectByPrimaryKey(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public int updateByPrimaryKey(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }
}
