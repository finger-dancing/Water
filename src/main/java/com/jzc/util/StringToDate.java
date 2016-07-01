package com.jzc.util;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDate implements Converter<String,Date> {

    @Override
    public Date convert(String arg0) {
        // TODO Auto-generated method stub
        
        String[] strs = arg0.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        Date date = new Date(year,month,day);
        
        return date;
    }

}
