package top.yclu.boot.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yclu.boot.config.model.Team;

@Slf4j
@RestController
@RequestMapping("/teams")
public class TeamController {

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        log.info("创建团队: {}, team");
        return team;
    }
}