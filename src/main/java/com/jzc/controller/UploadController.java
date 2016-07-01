package com.jzc.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@RequestMapping(value="/uploadImage",method=RequestMethod.POST)
	public ModelAndView uploadImage(HttpServletRequest request,
			MultipartFile image_name)
	{
		//得到图片的原始路径名称
		String originFileName = image_name.getOriginalFilename();
		//得到图片的后缀名
		String originFormat = originFileName.substring(originFileName.lastIndexOf(".")+1).toLowerCase();
		//图片的存放路径
		String path="D:\\source\\pic\\";
		//生成新的图片名称
		String newFileName = UUID.randomUUID()+"."+originFormat;
		//生成新图片文件
		File newFile = new File(path+newFileName);
		//将图片写入磁盘
		try {
			image_name.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/uploadVideo",method=RequestMethod.POST)
    public ModelAndView uploadVideo(HttpServletRequest request,
            MultipartFile video_name)
    {
        //得到图片的原始路径名称
        String originFileName = video_name.getOriginalFilename();
        //得到图片的后缀名
        String originFormat = originFileName.substring(originFileName.lastIndexOf(".")+1).toLowerCase();
        //图片的存放路径
        String path="D:\\source\\video\\";
        //生成新的图片名称
        String newFileName = UUID.randomUUID()+"."+originFormat;
        //生成新图片文件
        File newFile = new File(path+newFileName);
        //将图片写入磁盘
        try {
            video_name.transferTo(newFile);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
