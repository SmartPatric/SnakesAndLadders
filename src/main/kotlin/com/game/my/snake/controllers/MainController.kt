package com.game.my.snake.controllers

import com.game.my.snake.models.Token
import com.game.my.snake.services.BoardService
import com.game.my.snake.services.DiceService
import com.game.my.snake.services.TokenService
import lombok.AllArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
@AllArgsConstructor
class MainController(
    boardService: BoardService,
    val tokenService: TokenService,
    val diceService: DiceService,
) {
    val token: Token = Token()
    val board = boardService.createBoard()

    @GetMapping("/")
    fun blog(model: Model): String {
        model["board"] = board
        val position = tokenService.currentPosition(token)
        model["tokenWidth"] = position.width
        model["tokenHeight"] = position.height
        model["isWin"] = tokenService.isTokenWin(token)
        return "main"
    }

    @GetMapping("/generate")
    fun generate(model: Model): String {
        model["generated"] = diceService.generateNum()
        blog(model)
        return "main"
    }

    @GetMapping("/reset")
    fun resetGame(model: Model): String {
        tokenService.newGame(token)
        return "redirect:/"
    }

    @GetMapping("/move/{points}")
    fun moveToken(model: Model, @PathVariable(value = "points") points: Int): String {
        tokenService.move(token, points)
        return "redirect:/"
    }
}