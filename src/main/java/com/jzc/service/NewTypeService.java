package com.jzc.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzc.dao.NewTypeMapper;
import com.jzc.domain.NewType;

@Service("newTypeService")
public class NewTypeService {
    
    
	NewTypeMapper newTypeMapper;

	public NewTypeMapper getNewTypeMapper() {
		return newTypeMapper;
	}
	@Resource
	public void setNewTypeMapper(NewTypeMapper newTypeMapper) {
		this.newTypeMapper = newTypeMapper;
	}
	
	//增加新闻类别
	public boolean addNewsType(NewType newType)
	{
		int num = newTypeMapper.insertSelective(newType);
		if(num==1)
			return true;
		else 
			return false;
	}
	
	//删除新闻类别
	public boolean deleteNewsType(NewType newType)
	{
		int id = newType.getId();
		int num = newTypeMapper.deleteByPrimaryKey(id);
		if(num==1)
			return true;
		else
			return false;
	}
}
