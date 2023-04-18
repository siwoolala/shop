package com.shop.shop.service;

import com.shop.shop.domain.Member;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface MemberService {

    //회원가입
    Member memberJoin(Member member);

    //로그인
    Optional<Member> login(Member member);

}
