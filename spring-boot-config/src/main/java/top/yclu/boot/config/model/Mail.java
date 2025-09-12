package top.yclu.boot.config.model;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Mail {
    @Email
    private String from;
    @Email
    private String to;

    private String subject;

    private String content;


}
