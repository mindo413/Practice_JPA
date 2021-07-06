package com.dhkim.practice_jpa.member.controller;

import com.dhkim.practice_jpa.member.domain.Member;
import com.dhkim.practice_jpa.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/selectAll")
    public ResponseEntity<List<Member>> getMember(){
        List<Member> memberList = memberService.selectAllMember();

        System.out.println("전체 회원 : " + memberList);

        return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Member> createUser(@RequestBody Member member) {

        Member newMember = memberService.insertMember(member);

        System.out.println("신규 회원 : " + newMember);

        return new ResponseEntity<Member>(newMember,HttpStatus.CREATED);
    }
}
