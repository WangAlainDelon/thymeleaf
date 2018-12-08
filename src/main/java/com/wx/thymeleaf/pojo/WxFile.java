package com.wx.thymeleaf.pojo;

import org.springframework.web.multipart.MultipartFile;

public class WxFile {
    private Long id;
    private String fileName;
    private Integer downStauts;
    private String describe;
    private MultipartFile file;

    public Integer getDownStauts() {
        return downStauts;
    }
    public void setDownStauts(Integer downStauts) {
        this.downStauts = downStauts;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
