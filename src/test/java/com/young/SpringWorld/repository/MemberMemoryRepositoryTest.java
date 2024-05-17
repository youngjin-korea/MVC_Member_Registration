package com.young.SpringWorld.repository;

import com.young.SpringWorld.domain.Member;
import org.junit.jupiter.api.Test;

class MemberMemoryRepositoryTest {
    MemberRepository repository =new MemberMemoryRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);


    }
}
