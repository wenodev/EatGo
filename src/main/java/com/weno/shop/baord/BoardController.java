package com.weno.shop.baord;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity getAllBoards(){
        List<Board> boardList = boardService.getAllBoards();
        return new ResponseEntity(boardList, HttpStatus.OK);
    }

    @PostMapping("/boards")
    public ResponseEntity createBoards(@RequestBody Board resource){
        Board board = boardService.createBoards(resource);
        return new ResponseEntity(board, HttpStatus.CREATED);
    }

    @PutMapping("/boards/{id}")
    public ResponseEntity updateBoardById(@PathVariable Long id, @RequestBody Board resource){
        Board board = boardService.updateBoardById(id, resource);
        return new ResponseEntity(board, HttpStatus.OK);
    }

    @DeleteMapping("/boards/{id}")
    public ResponseEntity deleteBoardById(@PathVariable Long id){
        boardService.deleteBoardById(id);
        return new ResponseEntity("deleted", HttpStatus.OK);
    }

}
