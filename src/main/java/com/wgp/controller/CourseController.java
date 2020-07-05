package com.wgp.controller;

import com.wgp.common.ServerResponse;
import com.wgp.entity.Course;
import com.wgp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Course course);
//
//    int insertSelective(Course course);
//
//    Course selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Course course);
//
//    int updateByPrimaryKey(Course course);


    @Autowired
    private CourseService courseService;

    /**
     * 删除课程信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id) {
        if (courseService.deleteByPrimaryKey(id) > 0) {

            return ServerResponse.createBySuccessMessage("删除用户成功");
        } else {

            return ServerResponse.createByErrorMessage("删除用户失败");
        }

    }

    /**
     * 添加课程信息
     * @param course
     * @return
     */
    @RequestMapping(value = "/insertSelective", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse insertSelective(Course course) {
        if (courseService.insert(course) > 0) {
            return ServerResponse.createBySuccessMessage("添加课程数据成功");
        } else {
            return ServerResponse.createByErrorMessage("添加课程数据失败");
        }
    }

    //
//
//    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public ServerResponse   selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
//        Admin admin=courseService.selectByPrimaryKey(id);
//        if(admin != null){
//            return ServerResponse.createBySuccess(1,admin);
//        }else{
//            return ServerResponse.createByErrorMessage("没有找到用户");
//        }
//    }
//
//
    /**
     * 更新课程信息
     * @param course
     * @return
     */
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Course course) {
        if (courseService.updateByPrimaryKeySelective(course) > 0) {
            return ServerResponse.createBySuccessMessage("更新课程数据成功");
        } else {
            return ServerResponse.createByErrorMessage("更新课程数据失败");
        }
    }

    /**
     * 查询全部课程信息
     * @param
     * @return
     */
    @RequestMapping(value = "/listAll", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ServerResponse listAll() {

        List<Course> courseList = courseService.selectAll();
        if (courseList.size() > 0) {
            return ServerResponse.createBySuccess(courseList.size(), courseList);
        } else {
            return ServerResponse.createByErrorMessage("没有找到课程信息");
        }
    }
}
