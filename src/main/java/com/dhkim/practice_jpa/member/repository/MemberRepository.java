package com.dhkim.practice_jpa.member.repository;

import com.dhkim.practice_jpa.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
