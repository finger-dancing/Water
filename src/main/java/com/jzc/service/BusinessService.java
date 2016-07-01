package com.jzc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzc.dao.BusinessMapper;
import com.jzc.domain.BusinessWithBLOBs;

@Service("businessService")
public class BusinessService {
    
	BusinessMapper businessMapper;

	public BusinessMapper getBusinessMapper() {
		return businessMapper;
	}
	@Resource
	public void setBusinessMapper(BusinessMapper businessMapper) {
		this.businessMapper = businessMapper;
	}
	
	//增加业务
	public boolean addBusiness(BusinessWithBLOBs business)
	{
		int num = businessMapper.insert(business);
		if(num==1)
			return true;
		else 
			return false;
	}
	
	//删除业务
	public boolean delBusiness(int id)
	{
		int num = businessMapper.deleteByPrimaryKey(id);
		if(num==1)
			return true;
		else 
			return false;
	}
	
	//更新业务
	public boolean updateBusiness(BusinessWithBLOBs business)
	{
		int id = business.getId();
		int num = businessMapper.updateByPrimaryKeyWithBLOBs(business);
		if(num==1)
			return true;
		else 
			return false;
	}
	
	//查找业务列表
	public ArrayList<BusinessWithBLOBs> findBusinessList(int tid){
	    ArrayList<BusinessWithBLOBs> buss =(ArrayList<BusinessWithBLOBs>)businessMapper.selectBusList(tid);
	    return buss;
	}
}
