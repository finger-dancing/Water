package com.jzc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzc.dao.TechnologyMapper;
import com.jzc.domain.TechnologyWithBLOBs;

@Service("technologyService")
public class TechnologyService {
    
    
	TechnologyMapper technologyMapper;

	public TechnologyMapper getTechnologyMapper() {
		return technologyMapper;
	}
	@Resource
	public void setTechnologyMapper(TechnologyMapper technologyMapper) {
		this.technologyMapper = technologyMapper;
	}
	
	//添加技术
	public boolean addTech(TechnologyWithBLOBs tech)
	{
		int num = technologyMapper.insert(tech);
		if(num==1)
			return true;
		else 
			return false;
	}
	//删除技术
	public boolean delTech(int id)
	{
		
		int num = technologyMapper.deleteByPrimaryKey(id);
		if(num==1)
			return true;
		else 
			return false;
	}
	//更改技术
	public boolean updateTech(TechnologyWithBLOBs tech)
	{
		int id = tech.getId();
		int num = technologyMapper.updateByPrimaryKeyWithBLOBs(tech);
		if(num==1)
			return true;
		else 
			return false;
	}
	
	//查找技术列表
	public ArrayList<TechnologyWithBLOBs> findTechList(int tid){
	    ArrayList<TechnologyWithBLOBs> techs = (ArrayList<TechnologyWithBLOBs>)technologyMapper.selectTechList(tid);
	    return techs;
	}
}
