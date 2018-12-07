package com.wx.thymeleaf.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/load/nodedata")
    @ResponseBody
    public String loadData(String ip)
    {
        if(ip!="1")
        {
            //
        }
       // String  josn="{\"msg\":\"{\\\"cpuPercent\\\":1.79728,\\\"physical_sockets\\\":2,\\\"cpu_cores_per_socket\\\":6,\\\"cpu_thread_per_core\\\":2,\\\"mem_total\\\":81920,\\\"mem_used\\\":15705,\\\"disk_sys_await\\\":1.00228,\\\"disk_sys_total\\\":110,\\\"disk_sys_used\\\":2.5,\\\"uptime\\\":0.286491,\\\"loadAvg\\\":\\\"0.02,0.29,0.34\\\"}\",\"ipjsonstring\":\"{\\\"alreadyUsedNum\\\":2,\\\"surplusNum\\\":61}\"}";
        Map<String,String> map=new HashMap<String,String>();
        map.put("msg","10");
        map.put("data","20");
        String string = JSON.toJSONString(map);
        System.out.println(string);
        return string;
    }
    @RequestMapping("/index/data")
    @ResponseBody
    public List<String> string()
    {
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        return list;
    }

}
