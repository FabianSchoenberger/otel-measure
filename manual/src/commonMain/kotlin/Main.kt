fun main() {
    span("main") {
        val gol = GameOfLife(512)
        gol.initialize {
            for (x in arrayOf(0, 16, 32, 48)) {
                for (y in arrayOf(0, 16, 32, 48)) {
                    it.glider(x, y)
                }
            }
        }
        gol.simulate(1000)
    }
    processor.shutdown()
    await(exporter)
}

fun Array<Array<Boolean>>.glider(x: Int, y: Int) = span("glider") {
    this[y][x + 2] = true
    this[y + 1][x] = true
    this[y + 1][x + 2] = true
    this[y + 2][x + 1] = true
    this[y + 2][x + 2] = true
}
