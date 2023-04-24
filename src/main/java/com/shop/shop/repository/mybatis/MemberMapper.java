package com.shop.shop.repository.mybatis;

import com.shop.shop.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    // 아이디 중복 체크
    int joinChk(String memberId);

    // 회원가입
    void join(Member member);

    Member findById(Long sequence);

    Optional<Member> findByLoginId(Member member);

    List<Member> findAll();
}
