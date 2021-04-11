package com.game.my.snake.services

import com.game.my.snake.models.Position
import com.game.my.snake.models.Token
import org.springframework.stereotype.Service

@Service
class TokenService {

    fun move(token: Token, points: Int) {
        token.moveCeil(points)
    }

    fun currentPosition(token: Token): Position {
        return token.returnCurrentPosition()
    }

    fun newGame(token: Token) {
        token.isWin = false
        token.cleaPosition()
    }

    fun isTokenWin(token: Token): Boolean {
        return token.isWin
    }
}