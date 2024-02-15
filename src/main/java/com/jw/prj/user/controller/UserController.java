package com.jw.prj.user.controller;

import com.jw.prj.user.model.service.UserService;
import com.jw.prj.user.model.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login")
    public String memberLogin() {
        return "user/login";
    }

    @GetMapping("/user/signUp")
    public String signUp() {
        return "user/signUp";
    }

    @PostMapping("/user/signUp")
    public String SignUp(@ModelAttribute User user, @RequestParam(name = "userAddress") String[] address,
                         RedirectAttributes redirect) {
        String joinedAddress = (address != null) ? String.join(",,", address) : "";

        log.info("user:::: {}", user.getUserId());
        log.info("joinedAddress:::: {}", joinedAddress);

        int result = userService.insertUser(user, joinedAddress);
        log.info("result:::: {}", result);

        String message = "";
        String path = "";

        if(result > 0) {
            message = "회원가입이 완료되었습니다.";
            path = "redirect:/";

        } else {
            message = "회원가입에 실패하였습니다. 다시 시도해주세요.";
            path = "redirect:/user/signUp";
        }

        return path;
    }





 }
