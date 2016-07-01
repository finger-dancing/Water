package com.jzc.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzc.dao.BusinessTypeMapper;
import com.jzc.domain.BusinessType;

@Service("businessTypeService")
public class BusinessTypeService {
    
	BusinessTypeMapper businessTypeMapper;

	public BusinessTypeMapper getBusinessTypeMapper() {
		return businessTypeMapper;
	}
	@Resource
	public void setBusinessTypeMapper(BusinessTypeMapper businessTypeMapper) {
		this.businessTypeMapper = businessTypeMapper;
	}
	//增加业务类别
	public boolean addBusinessType(BusinessType businessType)
	{
		int num = businessTypeMapper.insertSelective(businessType);
		if(num==1)
			return true;
		else 
			return false;
	}
	//删除业务类别
	public boolean delBusinessType(BusinessType businessType)
	{
		int id = businessType.getId();
		int num = businessTypeMapper.deleteByPrimaryKey(id);
		if(num==1)
			return true;
		else 
			return false;
	}
}
