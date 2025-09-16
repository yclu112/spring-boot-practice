package top.yclu.boot.config.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import top.yclu.boot.config.model.Mail;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class MailServiceTest {
    @Resource
    private MailService mailService;
    @Test
    void sendSimpleMail() {
        Mail mail=new Mail();
        mail.setTo("1527095504@qq.com");
        mail.setSubject("测试邮件");
        mail.setContent("测试邮件内容");
        mailService.sendSimpleMail(mail);
    }
    @Test
    void sendHtmlMail() {
        Mail mail=new Mail();

        mail.setTo("1527095504@qq.com");
        mail.setSubject("测试邮件");
        mail.setContent("<html><body><h1 color:blue>测试文本内容</h1></body></html>");
        mailService.sendHTMLMail(mail);
    }

}