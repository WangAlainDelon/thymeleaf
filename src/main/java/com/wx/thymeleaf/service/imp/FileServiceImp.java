package com.wx.thymeleaf.service.imp;

import com.wx.thymeleaf.dao.FileMapper;
import com.wx.thymeleaf.pojo.WxFile;
import com.wx.thymeleaf.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImp implements FileService {
    @Autowired
    private FileMapper fileMapper;
    @Override
    public List<WxFile> findFielList() {
        return fileMapper.findFielList();
    }
}
