package com.shop.shop.controller;

import com.shop.shop.domain.Board;
import com.shop.shop.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService service;

    @GetMapping
    public String boards(Model model, Board board) {
        List<Board> boards = service.board(board);
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    @GetMapping("/{boardSequence}")
    public String board(Model model, @PathVariable long boardSequence) {
        Board board = service.findByBoard(boardSequence).get();
        model.addAttribute("board", board);
        return "board/board";
    }

//    @PostMapping("/create/{memberId}")
//    public String create(@PathVariable String memberId, Board board, RedirectAttributes redirectAttributes) {
//
//        int createBoard = service.create(memberId, board);
//        if (createBoard == 0) {
//            return null;
//        }
//
//     /*   redirectAttributes("");
//        return "redirect:/board/{boardSequence}";
//*/
//    }


}
