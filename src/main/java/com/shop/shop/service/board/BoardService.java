package com.shop.shop.service.board;

import com.shop.shop.domain.Board;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BoardService {

    List<Board> board(Board board);

    Optional<Board> findByBoard(long boardSequence);

    int create(String memberId, Board board);
}
