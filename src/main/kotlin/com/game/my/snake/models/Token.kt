package com.game.my.snake.models


class Token(private var position: Int = 1) {
    var isWin = false

    fun moveCeil(points: Int): Int {
        when (position + points) {
            100 -> {
                position += points
                isWin = true
            }
            in 0..99 -> position += points
        }
        return position
    }

    fun returnCurrentPosition(): Position {
        var width = 40 + ((position - 1) % 10) * 60
        var height = 45 + ((position - 1) / 10) * 60
        if ((position / 10) % 2 == 1 && position % 10 != 0) {
            width = 580 - ((position - 1) % 10) * 60
        } else if ((position / 10) % 2 == 0 && position % 10 == 0) {
            width = 40
        }
        return Position(height, width)
    }

    fun cleaPosition() {
        position = 1
    }

    fun getPosition():Int {
        return position
    }
}