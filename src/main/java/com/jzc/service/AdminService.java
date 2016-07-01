package com.jzc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jzc.dao.AdminMapper;
import com.jzc.domain.Admin;

@Service("adminService")
public class AdminService {
	
	AdminMapper adminMapper;
	
	public AdminMapper getAdminMapper() {
		return adminMapper;
	}
	@Resource(name="adminMapper")
	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}
	
	//验证登录
	public boolean verifyLogin(String username,String password)
	{
		Admin admin = adminMapper.selectAdmin2(username);
		if(admin.getPassword().equals(password))
			return true;
		else return false;
	}
	
	//添加管理员
	public boolean addAdmin(Admin admin)
	{
		int num = adminMapper.insert(admin);
		if(num==1)
			return true;
		else return false;
	}
	
	//删除管理员
	public boolean deleteAdmin(Admin admin)
	{
		int id = admin.getId();
		int num = adminMapper.deleteByPrimaryKey(id);
		if(num==1)
			return true;
		else 
			return false;
	}
	//查找所有管理员
	public ArrayList<Admin> selectAllAdmin()
	{
		ArrayList<Admin> admins = (ArrayList<Admin>)adminMapper.selectAllAdmin();
		return admins;
	}
	//更新管理员
	public boolean updateAdmin(Admin admin)
	{
	    int num = adminMapper.updateByPrimaryKey(admin);
	    if(num==1)
            return true;
        else 
            return false;
	}
}
