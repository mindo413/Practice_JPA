package com.dhkim.practice_jpa.member.service;

import com.dhkim.practice_jpa.common.constants.ErrorCode;
import com.dhkim.practice_jpa.common.domain.APIResponseMsg;
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

    APIResponseMsg apiResMsg;

    public List<Member> selectAllMember(){

        List<Member> memberList = memberRepository.findAll();

        System.out.println("전체 회원 : " + memberList);

        return memberList;
    }

    public Optional<Member> selectMemberByMemberNo(Long memberNo){

        Optional<Member> member = Optional.ofNullable(memberRepository.findByMemberNo(memberNo).orElse(null));

        System.out.println("검색 회원 : " + member);

        return member;
    }

    public APIResponseMsg insertMember(Member member){

        try {
            memberRepository.save(member);
            apiResMsg = new APIResponseMsg(ErrorCode.SUCCESS);

        } catch (Exception e){
            apiResMsg = new APIResponseMsg(ErrorCode.ADD_MEMBER_ERR);
        }

        System.out.println("API 응답값 : " + apiResMsg);

        return apiResMsg;
    }

    public APIResponseMsg updateMember(Member member) {

        try{
            memberRepository.save(member);
            apiResMsg = new APIResponseMsg(ErrorCode.SUCCESS);
        } catch (Exception e){
            apiResMsg = new APIResponseMsg(ErrorCode.MODIFY_MEMBER_ERR);
        }

        System.out.println("API 응답값 : " + apiResMsg);

        return apiResMsg;
    }

    public APIResponseMsg deleteMember(Long memberNo){

        try{
            memberRepository.deleteById(memberNo);
            apiResMsg = new APIResponseMsg(ErrorCode.SUCCESS);
        }catch (Exception e){
            apiResMsg = new APIResponseMsg(ErrorCode.REMOVE_MEMBER_ERR);
        }

        System.out.println("API 응답값 : " + apiResMsg);

        return apiResMsg;
    }
}
