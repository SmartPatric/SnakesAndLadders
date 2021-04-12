package com.game.my.snake.services

import com.game.my.snake.models.Dice
import org.springframework.stereotype.Service

@Service
class DiceService {

    fun generateNum(): Int {
        return Dice.generateNumber()
    }
}