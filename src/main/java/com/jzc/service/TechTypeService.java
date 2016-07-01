package com.jzc.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzc.dao.TechTypeMapper;
import com.jzc.domain.TechType;

@Service("techTypeService")
public class TechTypeService {
    
   
	TechTypeMapper techTypeMapper;

	public TechTypeMapper getTechType() {
		return techTypeMapper;
	}
	@Resource
	public void setTechType(TechTypeMapper techTypeMapper) {
		this.techTypeMapper = techTypeMapper;
	}
	public boolean addTechType(TechType techType)
	{
		int num = techTypeMapper.insertSelective(techType);
		if(num==1)
			return true;
		else 
			return false;
	}
	public boolean delTechType(TechType techType)
	{
		int id = techType.getId();
		int num = techTypeMapper.deleteByPrimaryKey(id);
		if(num==1)
			return true;
		else 
			return false;
	}
}
