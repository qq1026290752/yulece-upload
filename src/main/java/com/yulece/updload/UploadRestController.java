package com.yulece.updload;

import com.yulece.updload.dto.ResultVo;
import com.yulece.updload.entity.UploadFile;
import com.yulece.updload.service.FileService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UploadRestController
 * @Package com.yulece.updload
 * @Description:
 * @Date 2019-03-22 21:04
 **/
@RestController
@RequestMapping("/upload")
public class UploadRestController {

    @Autowired
    private FileService fileService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddmmhhss");

    @PostMapping("/file")
    public ResultVo file(@RequestParam("path") MultipartFile commonsMultipartFile){
        if(commonsMultipartFile.isEmpty()) {
            return ResultVo.createErrorResultVo("上传文件为空");
        }
        UploadFile file = new UploadFile();
        String originalFileName = commonsMultipartFile.getOriginalFilename();
        String fileSuffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileId = simpleDateFormat.format(new Date()).concat(RandomStringUtils.randomNumeric(7));
        file.setFileId(fileId);
        file.setFileName(fileId.concat(".").concat(fileSuffix));
        file.setFileSuffix(fileSuffix);
        file.setFileSize(commonsMultipartFile.getSize());
        file.setFileHash(commonsMultipartFile.hashCode());
        file.setOriginalFileName(originalFileName);
        return fileService.uploadFileByCloud(commonsMultipartFile,file);
    }
}
