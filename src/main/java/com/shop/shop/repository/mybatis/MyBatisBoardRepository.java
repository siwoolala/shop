package com.shop.shop.repository.mybatis;

import com.shop.shop.domain.Board;
import com.shop.shop.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisBoardRepository implements BoardRepository {

    @Autowired
    private final BoardMapper mapper;

    //게시판 전체 조회
    @Override
    public List<Board> findAll(Board board) {
        return mapper.findAll(board);
    }

    //게시글 조회
    @Override
    public Optional<Board> findByBoard(Long boardSequence) {
        return mapper.findByBoard(boardSequence);
    }

    //게시글 작성
    @Override
    public int create(String memberId, Board board) {
        return mapper.create(memberId, board);
    }

    //게시글 수정
    @Override
    public void update(Long boardSequence, Board memberId) {
        mapper.update(boardSequence, memberId);
    }
}
