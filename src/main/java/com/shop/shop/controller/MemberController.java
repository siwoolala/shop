package com.shop.shop.controller;

import com.shop.shop.domain.Member;
import com.shop.shop.service.member.MemberService;
import com.shop.shop.web.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
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
    public String join (@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model) {

        Map<String, String> errors = new HashMap<>();

        // 아이디 중복 체크
        int idChk = memberService.joinChk(member.getMemberId());

        if (idChk != 0) {
            errors.put("memberId","이미 사용중인 아이디 입니다.");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("errors",errors);
            return "member/join";
        }

        memberService.memberJoin(member);
        return "redirect:/";
    }

    //로그인 화면 이동
    @GetMapping("/login")
    public String loginHome(@ModelAttribute Member member) {
        return "member/login";
    }

    //회원 로그인
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute Member member
            , BindingResult bindingResult
            , HttpServletRequest request
    ) {
        Optional<Member> loginId = memberService.login(member);

        if (loginId.isEmpty()) {
            bindingResult.addError(new FieldError("member","memberId", member.getMemberId(),false, null, null, "아이디 또는 비밀번호가 맞지 않습니다."));
            return "member/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);

        return "loginHome";
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return "index";
    }
}
