package com.jzc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzc.domain.BusinessWithBLOBs;
import com.jzc.domain.CompanyInfoWithBLOBs;
import com.jzc.service.CompanyInfoService;
import com.jzc.util.ResponseResult;

@Controller
@RequestMapping("/company")
public class ComInfoController {
    
    CompanyInfoService comInfoService;
    
    
    public CompanyInfoService getComInfoService() {
        return comInfoService;
    }
    @Resource
    public void setComInfoService(CompanyInfoService comInfoService) {
        this.comInfoService = comInfoService;
    }

    /**
     * 编辑公司信息
     * */
    @RequestMapping(value="/updateCompanyInfo",method=RequestMethod.POST)
    public @ResponseBody ResponseResult updateComInfo(CompanyInfoWithBLOBs ciwb){
        ciwb.setId(1);
        boolean flag = comInfoService.updateCompanyInfo(ciwb);
        if(flag){
            ResponseResult res = new ResponseResult(1,"更新公司信息成功！",1,null);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"更新公司信息失败！",0,null);
            return res;
        }
    }
    
    /**
     * 查找公司信息
     * */
    @RequestMapping(value="/findCompanyInfo",method=RequestMethod.POST)
    public @ResponseBody ResponseResult findComInfo(int id){
        CompanyInfoWithBLOBs ciwb = comInfoService.findComInfo(id);
        if(ciwb!=null){
            ResponseResult res = new ResponseResult(1,"查找公司信息成功！",1,ciwb);
            return res;
        }else{
            ResponseResult res = new ResponseResult(0,"查找公司信息失败！",0,null);
            return res;
        }
    }
 
}
