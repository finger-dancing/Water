package com.jzc.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzc.dao.NewMapper;
import com.jzc.domain.New;
import com.jzc.domain.NewWithBLOBs;

@Service("newsService")
public class NewService {
    
    
	NewMapper newMapper;

	public NewMapper getNewMapper() {
		return newMapper;
	}
	@Resource
	public void setNewMapper(NewMapper newMapper) {
		this.newMapper = newMapper;
	}
	
	//添加新闻
	public boolean addNews(NewWithBLOBs news)
	{
		int num = newMapper.insert(news);
		if(num==1)
			return true;
		else 
			return false;
	}
	
	//删除新闻
	public boolean deleteNews(int id)
	{
		
		int num = newMapper.deleteByPrimaryKey(id);
		if(num==1)
			return true;
		else
			return false;
	}
	//更改新闻
	public boolean updateNews(NewWithBLOBs news)
	{
		int num = newMapper.updateByPrimaryKeyWithBLOBs(news);
		if(num==1)
			return true;
		else
			return false;
	}
	
	//查找新闻列表
	public ArrayList<NewWithBLOBs> findNewList(int tid){
	    ArrayList<NewWithBLOBs> news =(ArrayList<NewWithBLOBs>)newMapper.selectNewList(tid);
	    return news;
	}
}
