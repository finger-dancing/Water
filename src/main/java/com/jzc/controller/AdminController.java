package com.jzc.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jzc.domain.Admin;
import com.jzc.service.AdminService;
import com.jzc.util.ResponseResult;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}
	@Resource(name="adminService")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//验证登录
	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("....");
		boolean flag = adminService.verifyLogin(username, password);
		
		ModelAndView mav = new ModelAndView();
		if(flag){
		    mav.setViewName("main");
		    mav.addObject("code", "1");
		    mav.addObject("msg", "登录成功！");
		    return mav;
		}else{
		    mav.setViewName("login");
		    mav.addObject("code", "0");
		    mav.addObject("error", "用户名密码不正确！");
		    return mav;
		}
		
		
	}
	//用户管理主界面
	@RequestMapping(value="/adminManager",method=RequestMethod.GET)
	public @ResponseBody ResponseResult adminManage()
	{
	    
		ArrayList<Admin> admins = adminService.selectAllAdmin();
		if(admins.isEmpty()){
		    ResponseResult res = new ResponseResult(0,"查找用户列表失败！",0,null);
		    return res;
		}else{
		    ResponseResult res = new ResponseResult(1,"查找用户列表成功！",admins.size(),admins);
		    return res;
		}
		
	}
	
	//添加用户
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	public @ResponseBody ResponseResult addAdmin(Admin admin)
	{
		boolean flag = adminService.addAdmin(admin);
		if(flag){
		    ResponseResult res = new ResponseResult(1,"添加用户成功！",1,null);
		    return res;
		}else{
		    ResponseResult res = new ResponseResult(0,"添加用户失败！",0,null);
		    return res;
		}
	}
	//删除用户
	@RequestMapping(value="/deleteAdmin",method=RequestMethod.POST)
    public @ResponseBody ResponseResult deleteAdmin(Admin admin)
    {
        boolean flag = adminService.deleteAdmin(admin);
        if(flag){
            ResponseResult res = new ResponseResult(1,"删除用户成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"删除用户失败！",0,null);
            return res;
        }
       
    }
	//更新用户
	@RequestMapping(value="/updateAdmin",method=RequestMethod.POST)
    public @ResponseBody ResponseResult updateAdmin(Admin admin)
    {
        boolean flag = adminService.updateAdmin(admin);
        if(flag){
            ResponseResult res = new ResponseResult(1,"删除用户成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"删除用户失败！",0,null);
            return res;
        }
    }
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody Admin test(){
	    Admin admin = new Admin();
	    admin.setId(1);
	    admin.setName("jzc");
	    admin.setPassword("123");
	    admin.setUsername("jiangzichen");
	    admin.setEmail("jzc@163.com");
	    return admin;
	}
}
