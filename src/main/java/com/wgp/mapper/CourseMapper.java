package com.wgp.mapper;

import com.wgp.entity.Admin;
import com.wgp.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course course);

    int insertSelective(Course course);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course course);

    int updateByPrimaryKey(Course course);

    List<Course> selectAll();
}
