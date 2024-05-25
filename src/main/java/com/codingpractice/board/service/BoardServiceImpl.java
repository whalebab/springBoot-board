package com.codingpractice.board.service;

import com.codingpractice.board.dto.BoardDTO;
import com.codingpractice.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }

    @Override
    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    @Override
    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }


}
