class Matrix(private val matrix: List<List<Int>>) {

    val saddlePoints =
            matrix.indices.map { row ->
                matrix[row].indices.map { col ->
                    MatrixCoordinate(row + 1, col + 1)
                }.filter { it.isSaddlePoint() }
            }.flatten().toSet()

    private fun MatrixCoordinate.isSaddlePoint(): Boolean {

        val value = matrix[this.row - 1][this.col - 1]

        if (matrix[this.row - 1].any { it > value }) return false

        if (matrix.indices.map { matrix[it][this.col - 1] }.any { it < value }) return false

        return true
    }
}