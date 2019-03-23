package com.yulece.updload;

import com.yulece.updload.entity.UploadFile;
import com.yulece.updload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@Controller
public class YuleceUploadApplication {

    @Autowired
    private FileService fileService;

    public static void main(String[] args) {
        SpringApplication.run(YuleceUploadApplication.class, args);
    }

    @GetMapping()
    public ModelAndView toIndex(){
        ModelAndView index = new ModelAndView("index");
        List<UploadFile> files = fileService.findAllFile();
        index.addObject("files",files);
        return index;
    }
}
