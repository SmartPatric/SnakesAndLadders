package com.game.my.snake.services

import com.game.my.snake.models.BoardBlock
import com.game.my.snake.models.Token
import org.springframework.stereotype.Service

@Service
class BoardService {

    fun createBoard(): Array<Array<BoardBlock>> {
        val board = Array(Token.BLOCKS_COUNT_PER_LINE) { Array(Token.BLOCKS_COUNT_PER_LINE) { BoardBlock() } }

        for (l in 0 until Token.BLOCKS_COUNT_PER_LINE) {
            val line = board[l]
            line.apply {
                for (el in 0 until Token.BLOCKS_COUNT_PER_LINE) {
                    val blockNumber = l * 10 + el + 1
                    if (l % 2 == 0) {
                        this[el].positionNumber = blockNumber
                    } else {
                        this[9 - el].positionNumber = blockNumber
                    }
                }
            }

        }
        return board
    }
}