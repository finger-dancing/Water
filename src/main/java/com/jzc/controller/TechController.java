package com.jzc.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzc.domain.NewWithBLOBs;
import com.jzc.domain.TechnologyWithBLOBs;
import com.jzc.service.TechnologyService;
import com.jzc.util.ResponseResult;

@Controller
@RequestMapping("/tech")
public class TechController {
    
    
    private TechnologyService technologyService;
    
    
    public TechnologyService getTechnologyService() {
        return technologyService;
    }


    @Resource
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }



    /**
     * 增加技术
     * 
     * */
    @RequestMapping(value="/addTech",method=RequestMethod.POST)
    public @ResponseBody ResponseResult addTech(TechnologyWithBLOBs tech){
        boolean flag = technologyService.addTech(tech);
        if(flag){
            ResponseResult res = new ResponseResult(1,"增加技术成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"增加技术失败！",0,null);
            return res;
        }
    }
    
    
    
    /**
     * 删除技术
     * 
     * */
    @RequestMapping(value="/deleteTech",method=RequestMethod.DELETE)
    public @ResponseBody ResponseResult delTech(int id){
        boolean flag = technologyService.delTech(id);
        if(flag){
            ResponseResult res = new ResponseResult(1,"删除技术成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"删除技术失败！",0,null);
            return res;
        }
    }
    
    
    
    /**
     * 更新技术
     * 
     * */
    @RequestMapping(value="/updateTech",method=RequestMethod.PUT)
    public @ResponseBody ResponseResult updateTech(TechnologyWithBLOBs tech){
        boolean flag = technologyService.updateTech(tech);
        if(flag){
            ResponseResult res = new ResponseResult(1,"更新技术成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"更新技术失败！",0,null);
            return res;
        }
    }
    
    
    
    /**
     * 查找技术列表
     * 
     * */
    @RequestMapping(value="/findTechList",method=RequestMethod.POST)
    public @ResponseBody ResponseResult findTechList(int tid){
        ArrayList<TechnologyWithBLOBs> techs = technologyService.findTechList(tid);
        if(!techs.isEmpty()){
            ResponseResult res = new ResponseResult(1,"更新技术成功！",techs.size(),techs);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"更新技术失败！",0,null);
            return res;
        }
    }
}
