package com.wx.thymeleaf.service;

import com.wx.thymeleaf.pojo.WxFile;

import java.util.List;

public interface FileService {
    List<WxFile> findFielList();
}
