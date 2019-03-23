package com.yulece.updload.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UploadFile
 * @Package com.yulece.updload.entity
 * @Description:
 * @Date 2019-03-23 13:48
 **/
@Entity
@Table(name = "file")
public class UploadFile {

    @Id
  //  @GeneratedValue(strategy = GenerationType.)
    private String fileId;
    private String fileName;
    private String fileSuffix;
    private Integer fileHash;
    private String filePath;
    private Long fileSize;
    private String originalFileName;
    private Date createTime;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public Integer getFileHash() {
        return fileHash;
    }

    public void setFileHash(Integer fileHash) {
        this.fileHash = fileHash;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
