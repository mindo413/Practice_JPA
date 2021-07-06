package com.dhkim.practice_jpa.member.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor()
@Entity(name="sample_member")
@ApiModel(description = "회원 모델")
public class Member {
    @Id
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
    @ApiModelProperty(value = "등록 일자")
    @CreationTimestamp
    @Column(name="regDate")
    private Timestamp regDate;

    @ApiModelProperty(value = "수정 일자")
    @UpdateTimestamp
    @Column(name="updDate")
    private Timestamp updDate;

}
