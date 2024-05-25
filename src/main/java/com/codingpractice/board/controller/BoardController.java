package com.codingpractice.board.controller;

import com.codingpractice.board.dto.BoardDTO;
import com.codingpractice.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;

    /**
     * 게시물 작성 폼 이동
     */
    @GetMapping("/save")
    public String addForm() {
        return "addForm";
    }

    /**
     * 게시물 등록
     */
    @PostMapping("/save")
    public String addBoard(@ModelAttribute BoardDTO boardDTO) {
        log.info("boardDTO = {}", boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    /**
     * 게시판 목록 출력
     */
    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        log.info("boardDTOList ={}", boardList);
        return "list";
    }


}
