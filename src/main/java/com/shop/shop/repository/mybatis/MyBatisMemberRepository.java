package com.shop.shop.repository.mybatis;

import com.shop.shop.domain.Member;
import com.shop.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public Member join(Member member) {
        memberMapper.join(member);
        return member;
    }

    @Override
    public Optional<Member> findByLoginId(Member member) {
        return memberMapper.findByLoginId(member);
    }
}
