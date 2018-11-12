package domain

class LottoKt(values: String? = null) {
    var numbers: MutableList<Int>
        private set

    init {
        numbers = when(values.isNullOrEmpty()) {
            true -> LottoNumbersKt().value
            false -> LottoNumbersKt(values!!).value
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val PRICE = 1000
    }
}
