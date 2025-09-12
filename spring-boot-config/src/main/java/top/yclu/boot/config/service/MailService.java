package top.yclu.boot.config.service;

import jakarta.validation.Valid;
import top.yclu.boot.config.enums.ResultStatus;
import top.yclu.boot.config.model.Mail;


public interface MailService {
    ResultStatus sendSimpleMail(Mail mail);

    ResultStatus sendHTMLMail(Mail mail);
}
