package com.jzc.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzc.dao.CompanyInfoMapper;
import com.jzc.domain.CompanyInfoWithBLOBs;

@Service("companyInfoService")
public class CompanyInfoService {
    
	CompanyInfoMapper companyInfoMapper;

	public CompanyInfoMapper getCompanyInfoMapper() {
		return companyInfoMapper;
	}
	@Resource
	public void setCompanyInfoMapper(CompanyInfoMapper companyInfoMapper) {
		this.companyInfoMapper = companyInfoMapper;
	}
	
	//更新公司的信息
	public boolean updateCompanyInfo(CompanyInfoWithBLOBs ciwb)
	{
		int num = companyInfoMapper.updateByPrimaryKeyWithBLOBs(ciwb);
		if(num==1)
			return true;
		else
			return false;
	}
	
	//查找公司信息
	public CompanyInfoWithBLOBs findComInfo(int id){
	    CompanyInfoWithBLOBs ciwb = companyInfoMapper.selectByPrimaryKey(id);
	    return ciwb;
	}
	
	
	
	
	
}
