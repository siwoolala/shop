package com.shop.shop.controller;

import com.shop.shop.domain.Member;
import com.shop.shop.web.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RootController {

    @GetMapping("/")
    public String root(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false)Member member, Model model) {

        if (member == null) {
            return "index";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }
}
