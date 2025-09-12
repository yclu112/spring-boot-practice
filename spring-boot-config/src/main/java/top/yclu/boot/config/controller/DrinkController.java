package top.yclu.boot.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yclu.boot.config.enums.DrinkType;
import top.yclu.boot.config.enums.ExpressStatus;
@RestController
@RequestMapping("/drinks")
public class DrinkController {
    @GetMapping("/{type}")
    public String selectDrink(@PathVariable DrinkType type) {
        return String.format("您选择的是：%s，价格：%.2f元",
                type.getDescription(),
                type.getPrice());
    }
}
