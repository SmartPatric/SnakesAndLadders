package com.game.my.snake

import com.game.my.snake.models.Token
import com.game.my.snake.services.BoardService
import com.game.my.snake.services.DiceService
import com.game.my.snake.services.TokenService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class SnakeApplicationTests {

    @Autowired
    private val boardService: BoardService? = null

    @Autowired
    private val diceService: DiceService? = null

    @Autowired
    private val tokenService: TokenService? = null

    @Test
    @Throws(Exception::class)
    fun contextLoads() {
        assertThat(boardService).isNotNull
        assertThat(diceService).isNotNull
        assertThat(tokenService).isNotNull
    }

    @Test
    fun testMoveToken() {
        val token = Token()
        tokenService?.move(token, 5)
        assertThat(token.getPosition() == 6)
    }

    @Test
    fun testMoveTokenVisual() {
        val token = Token()
        tokenService?.move(token, 5)
        val position = tokenService?.currentPosition(token)
        if (position != null) {
            assertThat(position.height == 45 + ((token.getPosition() - 1) / 10) * 60)
        }
        if (position != null) {
            assertThat(position.width == 40 + ((token.getPosition() - 1) % 10) * 60)
        }
    }

    @Test
    fun testNewGame() {
        val token = Token()
        tokenService?.move(token, 5)
        tokenService?.newGame(token)
        assertThat(token.getPosition() == 1)
        assert(!token.isWin)
    }

    @Test
    fun testWin() {
        val token = Token()
        tokenService?.move(token, 99)
        assert(token.isWin)
    }

    @Test
    fun generateNumWithDice() {
        var inRange = true
        for (i in 1..100) {
            if (diceService?.generateNum() !in 1..6) {
                inRange = false
                break
            }
        }
        assert(inRange)
    }

    @Test
    fun testCreateBoard() {
        assertThat(boardService?.createBoard()!=null)
    }
}
