package top.yclu.boot.config.model;

import lombok.Data;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
@Component
public class Team {
    @Value("${team.name}")
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @Value("${team.leader}")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 8)
    private String leader;

    @Value("${team.phone}")
    @Pattern(regexp = "^[0-9]{11}$")
    private String phone;

    @Value("${team.age}")
    @Min(1)
    @Max(4)
    private Integer age;

    @Past
    private LocalDate createTime;
}