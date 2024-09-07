package org.example.controller;

import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.example.utils.AliOSSUtils;
import org.example.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
/*    public Result upload(String username, Integer age, MultipartFile image) throws Exception{
        log.info("文件上传：{},{},{}",username,age,image);
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();
        //构建唯一文件名（不重复）-uuid（通用唯一识别码）
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName= UUID.randomUUID().toString()+extname;
        log.info("新文件名：{}",newFileName);
        //将文件存储在服务器端本地磁盘
        image.transferTo(new File("D:\\0AMyFolder\\images\\"+newFileName));
        return Result.success();
    }*/
    public Result upload(MultipartFile image) throws IOException, ClientException {
        log.info("文件上传：{}", image.getOriginalFilename());
        //调用阿里云OSS工具类文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，访问的url:{}", url);
        return Result.success(url);
    }
}
