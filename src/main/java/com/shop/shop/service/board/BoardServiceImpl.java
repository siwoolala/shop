package com.shop.shop.service.board;

import com.shop.shop.domain.Board;
import com.shop.shop.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    public List<Board> board(Board board) {
        return repository.findAll(board);
    }

    @Override
    public Optional<Board> findByBoard(long boardSequence) {
        return repository.findByBoard(boardSequence);
    }

    @Override
    public int create(String memberId, Board board) {
        return repository.create(memberId, board);
    }
}
