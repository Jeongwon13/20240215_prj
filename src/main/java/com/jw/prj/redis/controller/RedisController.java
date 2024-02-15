package com.jw.prj.redis.controller;

import com.jw.prj.redis.service.RedisService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RedisController {

    private final RedisService redisService;

    @PostMapping(value = "/getRedisStringValue")
    public void getRedisStringValue(String key, String value) {
        redisService.getRedisStringValue(key, value);
    }

    @GetMapping("/getSessionId")
    public String getSessionId(HttpSession session) {
        return session.getId();
    }


}
