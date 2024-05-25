package com.codingpractice.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BoardDTO {
    private Long id;                // 게시글 글번호
    private String boardWriter;     // 게시글 작성자
    private String boardPass;       // 게시글 비밀번호
    private String boardTitle;      // 게시글 제목
    private String boardContents;   // 게시글 내용
    private int boardHits;          // 게시글 조회수
    private String createdAt;       // 게시글 작성시간
}
