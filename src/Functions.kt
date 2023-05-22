import pt.isel.canvas.*
import kotlin.random.*

fun RoundSquare.drawRoundSquare(c: Canvas) {
    c.erase()
    val cont = side / 2
    val f = (cont * round).toInt()

    c.drawRect(center.x - cont, center.y - cont + f, side, side - f * 2, color) //Horizontal
    c.drawRect(center.x - cont + f, center.y - cont, side - f * 2, side, color) // Vertical
    c.drawCircle(center.x - cont + f, center.y - cont + f, f, color) // esquerda cima
    c.drawCircle(center.x + cont - f, center.y - cont + f, f, color) // direita cima
    c.drawCircle(center.x - cont + f, center.y + cont - f, f, color) // esquerda baixo
    c.drawCircle(center.x + cont - f, center.y + cont - f, f, color) // direita baixo
    return
}

fun RoundSquare.processKey(key: Char) = when {
    key == 'S' && (side < RANGE_SIDE.last) -> copy(side = side + 1)
    key == 's' && (side > RANGE_SIDE.first) -> copy(side = side - 1)
    key == 'R' && (round < RANGE_ROUND.last) -> copy(round = round + 0.01)
    key == 'r' && (round > RANGE_ROUND.first) -> copy(round = round - 0.01)
    key == 'c' -> copy(color = nextInt(RANGE_COLOR))
    else -> this
}

fun nextInt(color: IntRange): Int {
    val randomColor = Random.nextInt(RANGE_COLOR.last)
    return randomColor
}

fun textDrawn(rs: RoundSquare, c: Canvas) {
    val hexColor = String.format("0x%06X", 0xFFFFFF and rs.color)
    c.drawText(
        10,
        c.height - 10,
        "center=(${rs.center.x},${rs.center.y}) side=${rs.side} " + "round=${(rs.round * 100).toInt()}% color=${(hexColor)}",
        BLACK,
        16
    )
}
