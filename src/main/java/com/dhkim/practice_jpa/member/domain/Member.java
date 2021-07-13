package com.dhkim.practice_jpa.member.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor()
@Entity(name="sample_member")
@ApiModel(description = "회원 모델")
public class Member {
    @Id
    @NotNull
    @ApiModelProperty(value = "회원 번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memberNo")
    private Long memberNo;

    @ApiModelProperty(value = "회원 아이디")
    @Column(name="memberId")
    private String memberId;

    @ApiModelProperty(value = "회원 명")
    @Column(name="memberName")
    private String memberName;

    @ApiModelProperty(value = "등록 일자", hidden = true)
    @CreationTimestamp
    @Column(name="regDate", updatable = false)
    private Timestamp regDate;

    @Builder(builderClassName = "MemberinsertBuilder", builderMethodName = "MemberInsertBuilder")
    public Member(String memberId, String memberName){
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
