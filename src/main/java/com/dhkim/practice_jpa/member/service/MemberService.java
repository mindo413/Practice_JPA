package com.dhkim.practice_jpa.member.service;

import com.dhkim.practice_jpa.member.domain.Member;
import com.dhkim.practice_jpa.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> selectAllMember(){
        List<Member> members = memberRepository.findAll();
        return members;
    }

    public Optional<Member> selectMemberById(Long memberNo){
        Optional<Member> member = memberRepository.findById(memberNo);

        return  member;
    }

    public void deleteMemberById(Long memberNo){
        memberRepository.deleteById(memberNo);
    }

    public Member insertMember(Member member){
        Member members = memberRepository.save(member);

        return members;
    }

}
