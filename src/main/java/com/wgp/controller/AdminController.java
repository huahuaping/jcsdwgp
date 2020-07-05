package com.wgp.controller;

import com.wgp.common.ServerResponse;
import com.wgp.entity.Admin;
import com.wgp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource(name="adminServiceImpl")
    @Autowired
    private AdminService adminService;


    @RequestMapping("/list")
    public String list(){
        return "adminlist";
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(adminService.deleteByPrimaryKey(id)>0){
           // response.getWriter().println("{\"status\":0,\"msg\":\"删除用户成功\"");
            return ServerResponse.createBySuccessMessage("删除用户成功");
        }else{
            //response.getWriter().println("{\"status\":1,\"msg\":\"删除用户失败\"");
            return ServerResponse.createByErrorMessage("删除用户失败");
        }

    }


    @RequestMapping(value = "/insert",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   insert(/*Admin record,*/ HttpServletRequest request, HttpServletResponse response) throws IOException {
        Admin admin=new Admin();
        admin.setName("zhangsan");
        admin.setPass("zhangsan");
        admin.setPhone("11111");
        admin.setEmail("11111");
        admin.setQq("8888");
        admin.setAtype("2");
        if(adminService.insert(admin)>0){
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }else{
            return ServerResponse.createByErrorMessage("添加用户失败");
        }
    }


    @RequestMapping(value = "/insertSelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  insertSelective(Admin record, HttpServletRequest request, HttpServletResponse response){
        System.out.println(record.getName()+","+record.getPass());
        if(adminService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }else{
            return ServerResponse.createByErrorMessage("添加数据失败");
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
            Admin admin=adminService.selectByPrimaryKey(id);
            if(admin != null){
                return ServerResponse.createBySuccess(1,admin);
            }else{
                return ServerResponse.createByErrorMessage("没有找到用户");
            }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Admin record, HttpServletRequest request, HttpServletResponse response){
        if(adminService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccessMessage("更新数据成功");
        }else{
            return ServerResponse.createByErrorMessage("更新数据失败");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  updateByPrimaryKey(Admin record, HttpServletRequest request, HttpServletResponse response){}


    @RequestMapping(value = "/listAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   listAll( HttpServletRequest request, HttpServletResponse response){

       List<Admin> adminList=adminService.selectAll();
       System.out.println("ok");
        if(adminList.size()>0){
            return ServerResponse.createBySuccess(adminList.size(),adminList);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }
}
