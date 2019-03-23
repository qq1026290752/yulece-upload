package com.yulece.updload.dao;

import com.yulece.updload.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: FileRepository
 * @Package com.yulece.updload.dao
 * @Description:
 * @Date 2019-03-23 14:51
 **/
@Repository
public interface FileRepository extends JpaRepository <UploadFile,String>{
}
