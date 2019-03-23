package com.yulece.updload.service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.yulece.updload.dao.FileRepository;
import com.yulece.updload.dto.ResultVo;
import com.yulece.updload.entity.UploadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: FileService
 * @Package com.yulece.updload.service
 * @Description:
 * @Date 2019-03-23 14:08
 **/
@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);
    public ResultVo uploadFileByCloud(MultipartFile commonsMultipartFile, UploadFile file) {
        String tag = "";
        COSClient cosClient = null;
        try{
            COSCredentials cred = new BasicCOSCredentials("AKIDfVZzIr9h82r1QxvsF6sTLetHuQCz73JL",
                    "NuMsPRm7m9S4i3YXfufkFoIOVUVfuANz");
            ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));
            cosClient = new COSClient(cred, clientConfig);
            String bucketName = "upload-1251448233";
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(commonsMultipartFile.getSize());
            objectMetadata.setContentType(commonsMultipartFile.getContentType());
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, file.getOriginalFileName(), commonsMultipartFile.getInputStream(),objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            tag = putObjectResult.getETag();
            LOGGER.info("返回数据的tag,内容是{}",tag);
        } catch (CosClientException cle) {
            LOGGER.error("del object failed.CosClientException", cle);
            return ResultVo.createErrorResultVo("文件上传失败,请联系管理员,失败原因是:" + cle.getMessage());
        } catch (IOException io){
            LOGGER.error("IO 异常", io);
            return ResultVo.createErrorResultVo("文件上传失败,请联系管理员,失败原因是:" + io.getMessage());
        }finally {
            cosClient.shutdown();
        }
        String filePath = "http://upload-1251448233.cosbj.myqcloud.com/".concat(file.getOriginalFileName());
        file.setFilePath(filePath);
        file.setCreateTime(new Date());
        try{
            fileRepository.save(file);
        }catch (Exception ex){
            LOGGER.debug("保存文件异常,异常原因是:{}",ex.getMessage());
            return ResultVo.createErrorResultVo("文件保存异常,请联系管理员,失败原因是:" + ex.getMessage());
        }
        return ResultVo.createSuccessResultVo(filePath);

    }

    public List<UploadFile> findAllFile() {
        return fileRepository.findAll();
    }
}
