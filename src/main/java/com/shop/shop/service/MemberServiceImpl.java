package com.shop.shop.service;

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

    @Override
    public Member memberJoin(Member member) {
        return repository.join(member);
    }

    @Override
    public Optional<Member> login(Member member) {
        return repository.findByLoginId(member);
    }
}
