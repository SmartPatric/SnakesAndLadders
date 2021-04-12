package com.game.my.snake.models

import java.util.*

object Dice {

    fun generateNumber(): Int {
        return Random(System.nanoTime()).nextInt(6) + 1
    }
}