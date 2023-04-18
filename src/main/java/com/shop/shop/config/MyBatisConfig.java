package com.shop.shop.config;

import com.shop.shop.repository.MemberRepository;
import com.shop.shop.repository.mybatis.MemberMapper;
import com.shop.shop.repository.mybatis.MyBatisMemberRepository;
import com.shop.shop.service.MemberService;
import com.shop.shop.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final MemberMapper memberMapper;

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MyBatisMemberRepository(memberMapper);
    }
}
