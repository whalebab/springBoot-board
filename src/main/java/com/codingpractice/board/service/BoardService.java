package com.codingpractice.board.service;

import com.codingpractice.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    // 게시물 저장
    void save(BoardDTO boardDTO);

    // 게시물 전체 조회
    List<BoardDTO> findAll();
}
