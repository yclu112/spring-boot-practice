package top.yclu.boot.config.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import top.yclu.boot.config.config.OssConfig;
import top.yclu.boot.config.service.OssService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
@Service
@Slf4j
public class OssServiceImpl implements OssService {

    @Resource
    private OssConfig ossConfig;

    @Override
    public String upload(MultipartFile file) {
        if (file != null) {
            // 获取原始文件名
            String originalFilename = file.getOriginalFilename();
            // 获取文件后缀
            assert originalFilename != null;
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 生成新的文件名
            String newFileName = UUID.randomUUID() + suffix;
            log.info("新文件名: {}", newFileName);
            // 读配置文件中的配置值
            String endpoint = ossConfig.getEndpoint();
            String bucket = ossConfig.getBucket();
            String accessKey = ossConfig.getAccessKey();
            String secretKey = ossConfig.getSecretKey();
            String dir = ossConfig.getDir();
            // 创建OSS客户端
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKey, secretKey);
            // 默认文件类型为jpg，默认为类型为application/octet-stream（二进制流）浏览器打开会下载而非预览
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");
            // 拼接最终文件在服务器的路径如：img/xxx.jpg
            String uploadPath = dir + newFileName;
            InputStream inputStream;
            try {
                // 获取文件输入流
                inputStream = file.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 使用putObject方法上传，指明文件的存储空间名称、文件名称、文件输入流，以及文件元信息
            ossClient.putObject(bucket, uploadPath, inputStream, meta);
            // 关闭OSS客户端
            ossClient.shutdown();
            // 返回文件访问路径
            return "https://" + bucket + "." + endpoint + "/" + uploadPath;
        }
        return "上传失败";
    }
}