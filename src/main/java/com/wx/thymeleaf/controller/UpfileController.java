package com.wx.thymeleaf.controller;

import com.wx.thymeleaf.pojo.WxFile;
import com.wx.thymeleaf.service.FileService;
import com.wx.thymeleaf.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/upload")
public class UpfileController {
    @Autowired
    private FileService fileService;
    private static final String TMP_PATH = "F:\\testupFile";
    private Map<String,List<WxFile>> map=new HashMap<String,List<WxFile>>();
    private volatile boolean isUpload=false;
    //正在上传的这个文件
    private WxFile wxFile;
    /**事先加载数据库数据的方法*/
    private void loadData()
    {
        if(map.size()!=0)
        {
            map.clear();
        }
        List<WxFile> list = fileService.findFielList();
        map.put("list",list);
    }
   private  WxFile getWxFileState(WxFile wxFile)
   {
       wxFile.setId(1l);
       wxFile.setFileName("文件4");
       wxFile.setDownStauts(0);
       wxFile.setDescribe("模板4");
       return  wxFile;
   }
   //模拟数据传输时候更新状态
    private  WxFile getWxFileRealTimeState(WxFile wxFile)
    {
        wxFile.setId(1l);
        wxFile.setFileName("文件4");
        wxFile.setDownStauts(wxFile.getDownStauts()+1);
        wxFile.setDescribe("模板4");
        return  wxFile;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String fileUploadInit(Model model) {
        // InfoMsg infoMsg = new InfoMsg();
        loadData();
        /**刷新页面的时候加载数据，需要判断是否在上传状态*/
        if (isUpload==true)
        {
            //实时获取上传状态，这样才能保证刷新页面上传不中断
            List<WxFile> list1 = map.get("list");
            //文件的实时传输状态
            if(wxFile.getDownStauts()>0)
            {
                getWxFileRealTimeState(wxFile);
            }
            else
            {
                getWxFileState(wxFile);
            }
            List<WxFile> list2=new ArrayList<WxFile>();
            //添加在list的头部
            for (int i=0;i<list1.size();i++)
            {
                if(i==0)
                {
                    list2.add(wxFile);
                }
                list2.add(list1.get(i));
            }
            model.addAttribute("list",list2);
            return "upload";
        }
        //无上传文件的时候正常加载数据。
        List<WxFile> list = map.get("list");
        model.addAttribute("list",list);
        return "upload";
    }
    /**
     * upload/file
     * */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("uploadFile") MultipartFile file) {
        //这儿上传文件MultipartFile是把MultipartFile先加载到内存中去，并没有立即返回，而实际上只需要传一个文件的路径即可。
        wxFile=new WxFile();
        wxFile.setFile(file);

        //打开正在上传的标志
        isUpload=true;
        //返回前端刷新页面,加载正在上传的选项
        return "ok";
      /*  Result infoMsg = new Result();
        if (wxFile.getFile().isEmpty()) {
            infoMsg.setCode("error");
            infoMsg.setMsg("Please select a file to upload");
            return infoMsg;
        }
        try {
            File tmp = new File(TMP_PATH, file.getOriginalFilename());
            if(!tmp.getParentFile().exists()){
                tmp.getParentFile().mkdirs();
            }
            wxFile.getFile().transferTo(tmp);

            infoMsg.setCode("success");
            infoMsg.setMsg("You successfully uploaded '" + wxFile.getFile().getOriginalFilename() + "'");

        } catch (IOException e) {
            infoMsg.setCode("error");
            infoMsg.setMsg("Uploaded file failed");
        }
        return infoMsg;
        //
        */
    }
}
