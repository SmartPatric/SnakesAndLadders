package com.game.my.snake.services

import com.game.my.snake.models.BoardBlock
import org.springframework.stereotype.Service

@Service
class BoardService {

    fun createBoard(): Array<Array<BoardBlock>> {
        val board = Array(10) { Array(10) { BoardBlock() } }
        for (l in 0..9){
            val line = board[l]
            for (el in 0..9){
                if (l%2==0) {
                    line[el].positionNumber = l * 10 + el + 1
                }else{
                    line[9-el].positionNumber = l * 10 + el + 1
                }
            }
        }
        return board
    }
}