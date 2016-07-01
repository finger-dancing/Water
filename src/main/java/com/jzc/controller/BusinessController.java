package com.jzc.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzc.domain.BusinessWithBLOBs;
import com.jzc.service.BusinessService;
import com.jzc.util.ResponseResult;

@Controller
@RequestMapping("/business")
public class BusinessController {
    
    
    private BusinessService businessService;
    
    
    public BusinessService getBusinessService() {
        return businessService;
    }
    @Resource
    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }
    
    /*
     * 查找业务列表
     * 
     */
    
    @RequestMapping(value="/findBusinessList",method=RequestMethod.PUT)
    public @ResponseBody ResponseResult findBusList(@RequestParam int tid){
        ArrayList<BusinessWithBLOBs> buss = businessService.findBusinessList(tid);
        if(buss.isEmpty()){
            ResponseResult res = new ResponseResult(0,"查找业务列表失败！",0,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(1,"查找业务列表成功！",buss.size(),buss);
            return res;
        }
    }
    
   

    /*
     * 添加业务
     * */
    @RequestMapping(value="/addBusiness",method=RequestMethod.POST)
    public @ResponseBody ResponseResult addBus(BusinessWithBLOBs busi){
        boolean flag = businessService.addBusiness(busi);
        if(flag){
            ResponseResult res = new ResponseResult(1,"添加业务成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"添加业务失败！",0,null);
            return res;
        }
    }
    
    /**
     * 删除业务
     * *
     */
    @RequestMapping(value="/deleteBusiness",method=RequestMethod.DELETE)
    public @ResponseBody ResponseResult delBus(@RequestParam int id){
        boolean flag = businessService.delBusiness(id);
        if(flag){
            ResponseResult res = new ResponseResult(1,"删除业务成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"删除业务失败！",0,null);
            return res;
        }
    }
    
    /**
     * 更新业务
     * */
    @RequestMapping(value="/updateBusiness",method=RequestMethod.PUT)
    public @ResponseBody ResponseResult updBus(BusinessWithBLOBs busi){
        boolean flag = businessService.updateBusiness(busi);
        if(flag){
            ResponseResult res = new ResponseResult(1,"更新业务成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"更新业务失败！",0,null);
            return res;
        }
    }
}
