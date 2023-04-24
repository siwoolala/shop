package com.shop.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSequence;
    @Column(nullable = false)
    private String memberId;
    private String subject;
    private String contents;
    private Date writerDate;
    private Long likeCount;
}

/*
*
drop table if exists board CASCADE;
create table board (
 boardSequence bigint generated by default as identity,
 member_id varchar(10),
 subject varchar(30),
 contents varchar(200),
 writerDate datetime,
 likeCount number,
 primary key (boardSequence),
 foreign key(member_id) references member(member_id) on delete cascade
 );
 *
*
* */