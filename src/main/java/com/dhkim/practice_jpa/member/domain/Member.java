package com.dhkim.practice_jpa.member.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor()
@Entity(name="sample_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID
    @Column(name="memberNo")
    private Long memberNo;     // 회원 번호

    @Column(name="memberId")
    private String memberId;   // 회원 아이디

    @Column(name="memberName")
    private String memberName; // 회원명

    @Builder
    public Member(String memberId, String memberName){
        this.memberId = memberId;
        this.memberName = memberName;
    }

}
