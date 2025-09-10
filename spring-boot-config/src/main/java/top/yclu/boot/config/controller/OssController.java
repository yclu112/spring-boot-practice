package top.yclu.boot.config.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import top.yclu.boot.config.service.OssService;

@RestController
@RequestMapping("/oss")
public class OssController {
    @Resource
    private OssService ossService;

    @PostMapping("upload")
    public String upload(MultipartFile file) {
        return ossService.upload(file);
    }

}
