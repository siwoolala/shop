package com.shop.shop.repository.mybatis;

import com.shop.shop.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper
@Component
public interface BoardMapper {
    List<Board> findAll(Board board);

    Optional<Board> findByBoard(Long boardSequence);

    int create(String memberId, Board board);

    void update(Long boardSequence, Board memberId);
}
