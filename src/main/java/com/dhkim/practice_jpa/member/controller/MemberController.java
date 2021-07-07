package com.dhkim.practice_jpa.member.controller;

import com.dhkim.practice_jpa.common.domain.APIResponseMsg;
import com.dhkim.practice_jpa.member.domain.Member;
import com.dhkim.practice_jpa.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
@Api(tags = "[Member] 회원", description = "회원 데이터 관리 API")
public class MemberController {

    @Autowired
    private MemberService memberService;

    ResponseEntity<APIResponseMsg> response;
    APIResponseMsg apiResponseMsg;
    
    @GetMapping("/selectAll")
    @ApiOperation(value = "전체 회원 조회", notes = "전체 회원 목록을 조회하는 API.")
    public List<Member> getMembers(){
        return memberService.selectAllMember();
    }

    @GetMapping("/selectByMemberNo/{memberNo}")
    @ApiOperation(value = "회원 조회", notes = "회원 번호로 회원 목록을 조회하는 API.\n" + "Member Entity Class의 memberNo값으로 데이터를 가져온다.")
    public Optional<Member> getMemberByMemberNo(@ApiParam(value="회원번호", required=true) @PathVariable("memberNo") long memberNo){
        return memberService.selectMemberByMemberNo(memberNo);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "회원 등록", notes = "회원 정보를 저장하는 API.\n" + "Member Entity Class에 데이터를 저장한다.")
    public ResponseEntity<APIResponseMsg> addMember(@RequestBody Member member) {

        apiResponseMsg = memberService.insertMember(member);

        if(apiResponseMsg.getRetVal().equals(0000)){
            response = new ResponseEntity<>(apiResponseMsg, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(apiResponseMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PutMapping("/update")
    @ApiOperation(value="회원 수정", notes = "회원 정보를 수정하는 API.\n" + "Member Entity Class의 memberNo값으로 데이터를 수정한다.")
    public ResponseEntity<APIResponseMsg> modifyMember(@RequestBody Member member){

        apiResponseMsg = memberService.updateMember(member);

        if(apiResponseMsg.getRetVal().equals(0000)){
            response = new ResponseEntity<>(apiResponseMsg, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(apiResponseMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping("/delete/{memberNo}")
    @ApiOperation(value="회원 삭제", notes="회원 정보를 삭제하는 API.\n" + "Member Entity Class의 memberNo값으로 데이터를 삭제한다.")
    public ResponseEntity<APIResponseMsg> removeMember(@ApiParam(value="회원번호", required=true) @PathVariable("memberNo") Long memberNo){

        apiResponseMsg = memberService.deleteMember(memberNo);

        if(apiResponseMsg.getRetVal().equals(0000)){
            response = new ResponseEntity<>(apiResponseMsg, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(apiResponseMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
