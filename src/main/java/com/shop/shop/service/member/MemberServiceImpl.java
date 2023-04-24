package com.shop.shop.service.member;

import com.shop.shop.domain.Member;
import com.shop.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository repository;


    // 아이디 중복 체크
    @Override
    public int joinChk(String memberId) {
        int idChk = repository.joinChk(memberId);
        return idChk;
    }

    // 회원가입
    @Override
    public Member memberJoin(Member member) {
        return repository.join(member);
    }

    // 로그인
    @Override
    public Optional<Member> login(Member member) {
        return repository.findByLoginId(member);
    }
}
