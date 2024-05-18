package com.young.SpringWorld.repository;

import com.young.SpringWorld.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 맴버 저장
    Member save(Member member);
    // Id, Name으로 멤버 찾기
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // 저장된 전체 찾아오기
    List<Member> findAll();
}
