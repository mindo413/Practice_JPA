package com.dhkim.practice_jpa.member.repository;

import com.dhkim.practice_jpa.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 회원 번호로 회원 검색
    Optional<Member> findByMemberNo(Long memberNo);
}
