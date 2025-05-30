fun main() {
    val gol = GameOfLife(100)
    gol.initialize {
        for (x in arrayOf(0, 25, 50, 75)) {
            for (y in arrayOf(0, 25, 50, 75)) {
                it.glider(x, y)
            }
        }
    }
    gol.simulate(500)
}

fun Array<Array<Boolean>>.glider(x: Int, y: Int) {
    this[y][x + 2] = true
    this[y + 1][x] = true
    this[y + 1][x + 2] = true
    this[y + 2][x + 1] = true
    this[y + 2][x + 2] = true
}
