package com.game.my.snake.models


class Token(private var position: Int = START_POSITION) {
    var isWin = NOT_WIN

    fun moveCeil(points: Int): Int {
        when (position + points) {
            WIN_POINTS -> {
                position += points
                isWin = WIN
            }
            in LOWEST_POINTS..HIGHEST_NOT_WIN_POINTS -> position += points
        }
        return position
    }

    fun returnCurrentPosition(): Position {
        var width = DEFAULT_WIDTH_POSITION + ((position - 1) % BLOCKS_COUNT_PER_LINE) * PIXELS_PER_BLOCK
        var height = DEFAULT_HEIGHT_POSITION + ((position - 1) / BLOCKS_COUNT_PER_LINE) * PIXELS_PER_BLOCK

        if ((position / BLOCKS_COUNT_PER_LINE) % 2 == 1
            && position % BLOCKS_COUNT_PER_LINE != 0
        ) {
            width = HEIGHT_MAX_POSITION - ((position - 1) % BLOCKS_COUNT_PER_LINE) * PIXELS_PER_BLOCK
        } else if ((position / BLOCKS_COUNT_PER_LINE) % 2 == 0
            && position % BLOCKS_COUNT_PER_LINE == 0
        ) {
            width = DEFAULT_WIDTH_POSITION
        }
        return Position(height, width)
    }

    fun cleaPosition() {
        position = START_POSITION
    }

    fun getPosition(): Int {
        return position
    }

    companion object {
        const val START_POSITION = 1
        const val WIN_POINTS = 100
        const val LOWEST_POINTS = 1
        const val HIGHEST_NOT_WIN_POINTS = 99
        const val DEFAULT_WIDTH_POSITION = 40
        const val DEFAULT_HEIGHT_POSITION = 45
        const val HEIGHT_MAX_POSITION = 580
        const val BLOCKS_COUNT_PER_LINE = 10
        const val PIXELS_PER_BLOCK = 60
        const val WIN = true
        const val NOT_WIN = false
    }
}