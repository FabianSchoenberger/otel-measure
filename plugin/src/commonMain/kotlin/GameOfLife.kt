class GameOfLife(
    private val size: Int
) {
    private val grid: Array<Array<Boolean>> = Array(size) { _ -> Array(size) { _ -> false } }

    fun initialize(
        action: (grid: Array<Array<Boolean>>) -> Unit
    ) {
        action(grid)
    }

    fun simulate(
        steps: Int
    ) {
        repeat(steps) {
            step()
        }
    }

    fun step() {
        val g: Array<Array<Boolean>> = Array(size) { i -> Array(size) { j -> false } }

        for (x in 0 until size) {
            for (y in 0 until size) {
                val alive = _neighbors(x, y)
                g[x][y] = when (alive) {
                    0, 1 -> false
                    2 -> grid[x][y]
                    3 -> true
                    else -> false
                }
            }
        }
    }

    // prepend underscore to ignore the function
    private fun _neighbors(
        x: Int,
        y: Int
    ): Int {
        var count = 0
        for (nx in x - 1..x + 1) {
            for (ny in y - 1..y + 1) {
                if (nx == x && ny == y) continue

                if (grid[nx.mod(size)][ny.mod(size)])
                    count++
            }
        }
        return count
    }
}
