package com.shop.shop.repository;

import com.shop.shop.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member join(Member member);

    Optional<Member> findByLoginId(Member member);

}
