package com.shop.shop.repository;

import com.shop.shop.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    // 아이디 중복 체크
    int joinChk(String memberId);

    // 회원가입
    Member join(Member member);

    // 로그인 확인
    Optional<Member> findByLoginId(Member member);

}
