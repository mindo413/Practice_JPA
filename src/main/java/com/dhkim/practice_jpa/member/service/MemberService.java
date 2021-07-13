package com.dhkim.practice_jpa.member.service;

import com.dhkim.practice_jpa.common.constants.ErrorCode;
import com.dhkim.practice_jpa.common.domain.APIResponseMsg;
import com.dhkim.practice_jpa.member.domain.Member;
import com.dhkim.practice_jpa.member.repository.MemberRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    APIResponseMsg apiResMsg;


    // selectAllMember() : 회원 전체 조회 서비스
    public List<Member> selectAllMember(){

        List<Member> memberList = memberRepository.findAll();

        return memberList;
    }

    // selectMemberByMemberNo() : 특정 회원 조회 서비스
    public Optional<Member> selectMemberByMemberNo(Long memberNo){

        Optional<Member> member = Optional.ofNullable(memberRepository.findByMemberNo(memberNo).orElse(null));

        return member;
    }

    // insertMember() : 회원 생성 서비스
    @Transactional
    public APIResponseMsg insertMember(String memberId, String memberName){

        Member member = Member.MemberInsertBuilder()
                .memberId(memberId)
                .memberName(memberName)
                .build();

        try {
            memberRepository.save(member);
            apiResMsg = new APIResponseMsg(ErrorCode.SUCCESS);

        } catch (Exception e){
            apiResMsg = new APIResponseMsg(ErrorCode.ADD_MEMBER_ERR);
        }

        return apiResMsg;
    }

    // updateMember() : 회원 업데이트 서비스
    @Transactional
    public APIResponseMsg updateMember(Member member) {

        // parameter validation
        // 회원 번호 체크
        if(member.getMemberNo() == null){
            apiResMsg = new APIResponseMsg(ErrorCode.NOT_INPUT_MEMBER_NO_ERR);
        } else {
            Optional<Member> searchMember = memberRepository.findByMemberNo(member.getMemberNo());

            if(searchMember.isPresent()){
                try{
                    Member updMember = searchMember.get();

                    // parameter validation
                    // whitespace, 공백문자, null => false
                    if(StringUtils.isNotBlank(member.getMemberId())){
                        updMember.setMemberId(member.getMemberId());
                    }
                    if(StringUtils.isNotBlank(member.getMemberName())){
                        updMember.setMemberName(member.getMemberName());
                    }

                    memberRepository.save(updMember);
                    apiResMsg = new APIResponseMsg(ErrorCode.SUCCESS);
                } catch (Exception e){
                    apiResMsg = new APIResponseMsg(ErrorCode.MODIFY_MEMBER_ERR);
                }
            } else{
                apiResMsg = new APIResponseMsg(ErrorCode.NOT_EXIST_MEMBER_ERR);
            }
        }

        return apiResMsg;
    }

    // updateMember() : 회원 삭제 서비스
    @Transactional
    public APIResponseMsg deleteMember(Long memberNo){

        try{
            memberRepository.deleteById(memberNo);
            apiResMsg = new APIResponseMsg(ErrorCode.SUCCESS);
        }catch (Exception e){
            apiResMsg = new APIResponseMsg(ErrorCode.REMOVE_MEMBER_ERR);
        }
        return apiResMsg;
    }
}
