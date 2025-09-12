package top.yclu.boot.config.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yclu.boot.config.enums.ExpressStatus;

@RestController
@RequestMapping("/express")
public class ExpressController {
    @GetMapping("/{status}")
    public String checkExpressStatus(@PathVariable ExpressStatus status) {
        return status.getLabel();
    }
}
