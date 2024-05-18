package com.young.SpringWorld;

import com.young.SpringWorld.repository.MemberMemoryRepository;
import com.young.SpringWorld.repository.MemberRepository;
import com.young.SpringWorld.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemberMemoryRepository();
    }
}
