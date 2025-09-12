package top.yclu.boot.config.controller;


import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yclu.boot.config.common.ApiResponse;
import top.yclu.boot.config.enums.ResultStatus;
import top.yclu.boot.config.model.Mail;
import top.yclu.boot.config.service.MailService;
@Slf4j
@RestController
@RequestMapping("/mail")
public class MailController {

    @Resource
    private MailService mailService;

    @PostMapping("/simple")
    public ResponseEntity<ApiResponse<ResultStatus>> sendSimpleMail(@Valid @RequestBody Mail mail) {
        ResultStatus rs = mailService.sendSimpleMail(mail);
        if (rs == ResultStatus.SUCCESS) {
            return ResponseEntity.ok(ApiResponse.success("发送成功", rs));
        }
        // 业务失败建议返回 400（参数/业务错误），而不是 200
        return ResponseEntity.badRequest().body(ApiResponse.error("发送失败"));
    }

    @PostMapping("/html")
    public ResponseEntity<ApiResponse<ResultStatus>> sendHtmlMail(@Valid @RequestBody Mail mail) {
        ResultStatus rs = mailService.sendHTMLMail(mail);
        return rs == ResultStatus.SUCCESS ? ResponseEntity.ok(ApiResponse.success("发送成功", rs)) : ResponseEntity.badRequest().body(ApiResponse.error("发送失败"));

    }
}