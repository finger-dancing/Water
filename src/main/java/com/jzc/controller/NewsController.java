package com.jzc.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzc.domain.CompanyInfoWithBLOBs;
import com.jzc.domain.NewWithBLOBs;
import com.jzc.service.NewService;
import com.jzc.util.ResponseResult;

@Controller
@RequestMapping("/news")
public class NewsController {
    
    
    private NewService newsService;
    
    
    public NewService getNewsService() {
        return newsService;
    }
    @Resource
    public void setNewsService(NewService newsService) {
        this.newsService = newsService;
    }

    /**
     * 增加新闻
     * 
     * */
    @RequestMapping(value="/addNew",method=RequestMethod.POST)
    public @ResponseBody ResponseResult addNew(NewWithBLOBs news){
        boolean flag = newsService.addNews(news);
        if(flag){
            ResponseResult res = new ResponseResult(1,"增加新闻成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"增加新闻失败！",0,null);
            return res;
        }
    }
    
    /**
     * 删除新闻
     * 
     * */
    @RequestMapping(value="/deleteNew",method=RequestMethod.DELETE)
    public @ResponseBody ResponseResult delNew(int id){
        boolean flag = newsService.deleteNews(id);
        if(flag){
            ResponseResult res = new ResponseResult(1,"删除新闻成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"删除新闻失败！",0,null);
            return res;
        }
    }
    
    
    /**
     * 更新新闻
     * 
     * */
    @RequestMapping(value="/updateNew",method=RequestMethod.PUT)
    public @ResponseBody ResponseResult updateNew(NewWithBLOBs news){
        boolean flag = newsService.updateNews(news);
        if(flag){
            ResponseResult res = new ResponseResult(1,"更新新闻成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"更新新闻失败！",0,null);
            return res;
        }
    }
    
    
    /**
     * 查找新闻列表
     * 
     * */
    @RequestMapping(value="/findNewList",method=RequestMethod.POST)
    public @ResponseBody ResponseResult findNewList(int tid){
        ArrayList<NewWithBLOBs> news = newsService.findNewList(tid);
        if(!news.isEmpty()){
            ResponseResult res = new ResponseResult(1,"查找新闻列表成功！",news.size(),news);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"更新新闻失败！",0,null);
            return res;
        }
    }
}
