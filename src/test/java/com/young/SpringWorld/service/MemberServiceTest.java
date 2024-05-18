package com.young.SpringWorld.service;

import com.young.SpringWorld.domain.Member;
import com.young.SpringWorld.repository.MemberMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberMemoryRepository memberMemoryRepository;
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        memberMemoryRepository = new MemberMemoryRepository();
        memberService = new MemberService(memberMemoryRepository);
    }

    @AfterEach
    void afterEach() {
        memberMemoryRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 주어진것
        Member member = new Member();
        member.setName("kim");
        //when 로직
        Long savedId = memberService.join(member);

        //then 결과
        Member member1 = memberService.findOne(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(member1.getName());
    }

    @Test
    void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재합니다");
//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재합니다");
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}