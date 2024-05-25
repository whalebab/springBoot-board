package com.codingpractice.board.controller;

import com.codingpractice.board.dto.BoardDTO;
import com.codingpractice.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/list";
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

    /**
     * 게시판 게시글 조회 및 조회수 증가
     */
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        // 조회수 처리
        boardService.updateHits(id);

        // 상세내용 가져오기
        BoardDTO board = boardService.findById(id);
        model.addAttribute("board", board);
        log.info("board ={}" , board);
        return "detail";
    }

    /**
     * 게시글 수정 폼이동
     */
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        BoardDTO board = boardService.findById(id);
        model.addAttribute("board", board);
        return "update";
    }

    /**
     * 게시글 수정
     */
    @PostMapping("/update/{id}")
    public String update(BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "detail";
    }

    /**
     * 게시글 삭제
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/list";
    }

}
