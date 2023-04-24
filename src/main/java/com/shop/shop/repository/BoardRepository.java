package com.shop.shop.repository;

import com.shop.shop.domain.Board;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BoardRepository {

    //게시판 조회
    List<Board> findAll(Board board);

    Optional<Board> findByBoard(Long boardSequence);

    int create (String memberId, Board board);

    void update(Long boardSequence, Board memberId);


}
