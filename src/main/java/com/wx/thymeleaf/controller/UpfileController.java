package com.wx.thymeleaf.controller;

import com.wx.thymeleaf.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UpfileController {
    private static final String TMP_PATH = "D:\\testupFile";
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String fileUploadInit() {
        // InfoMsg infoMsg = new InfoMsg();
        return "upload";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result fileUpload(@RequestParam("uploadFile") MultipartFile file) {
        Result infoMsg = new Result();
        if (file.isEmpty()) {
            infoMsg.setCode("error");
            infoMsg.setMsg("Please select a file to upload");
            return infoMsg;
        }
        try {
            File tmp = new File(TMP_PATH, file.getOriginalFilename());
            if(!tmp.getParentFile().exists()){
                tmp.getParentFile().mkdirs();
            }
            file.transferTo(tmp);

            infoMsg.setCode("success");
            infoMsg.setMsg("You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            infoMsg.setCode("error");
            infoMsg.setMsg("Uploaded file failed");
        }
        return infoMsg;
    }
}
