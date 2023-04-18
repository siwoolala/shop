package com.shop.shop.controller;

import com.shop.shop.domain.Member;
import com.shop.shop.repository.MemberRepository;
import com.shop.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입 화면 이동
    @GetMapping("/join")
    public String join (Member member) {
        return "member/join";
    }

    //회원 회원가입
    @PostMapping("/join")
    public String join (@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        memberService.memberJoin(member);
        return "redirect:/";
    }

    //로그인 화면 이동
    @GetMapping("/login")
    public String loginHome(@ModelAttribute("loginForm") Member loginForm) {
        return "member/login";
    }

    //회원 로그인
    @PostMapping("/login")
    public String login(@ModelAttribute Member member, HttpServletRequest request) {
        Optional<Member> loginId = memberService.login(member);

        if (loginId != null) {

        }
        return "redirect:/";
    }
}
