import pt.isel.canvas.*

fun main() {
    onStart {
        val cv = Canvas(600, 400, WHITE)
        var roundSquare = RoundSquare(Position(cv.width / 2, cv.height / 2), 200, 0.5, GREEN)
        roundSquare.drawRoundSquare(cv)
        textDrawn(roundSquare, cv)

        cv.onKeyPressed {
            roundSquare = roundSquare.processKey(it.char)
            roundSquare.drawRoundSquare(cv)
            textDrawn(roundSquare, cv)
        }

        cv.onMouseDown {
            roundSquare = roundSquare.copy(center = Position(it.x, it.y))
            roundSquare.drawRoundSquare(cv)
            textDrawn(roundSquare, cv)
        }
    }
    onFinish { }
}