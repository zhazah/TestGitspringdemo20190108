package com.example.springdemo.controller;

import com.example.springdemo.util.PageUtil;
import com.github.pagehelper.Page;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class BaseController {
    public <T> void setPageInfo(ModelAndView result, Page<T> page, String url, Map<String,?> map){
        int size = page.size();
        double a = size;
        double b = 20.0;
        double c = a / b;
        double ceil = Math.ceil(c);
        int totalCount = (int)ceil;
        Object pageNum = map.get("pageNum");
        Object pageSize = map.get("pageSize");
        PageUtil pageUtil = new PageUtil(Integer.valueOf(pageNum.toString()),Integer.valueOf(pageSize.toString()),totalCount,page.size());

        result.addObject("PageInfo",pageUtil);
        result.addObject("PageHtml",pageUtil.getPageScript(url,map));
    }
}
