data class RoundSquare(val center:Position, val side:Int, val round:Double, val color:Int)
data class Position(val x:Int, val y:Int)

val RANGE_ROUND = 0..1
val RANGE_SIDE = 10..400
val RANGE_COLOR = 0X000000..0XFFFFFF
