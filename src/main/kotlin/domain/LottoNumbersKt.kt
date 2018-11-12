package domain

import java.util.ArrayList
import java.util.stream.Collectors

class LottoNumbersKt {
    var value: MutableList<Int> = mutableListOf()
        private set

    private val randomNumbers: ArrayList<Int>
        get() {
            val numbers = ArrayList<Int>()
            val shuffleNumbers = lottoAllNumbers
            shuffleNumbers.shuffle()
            for (i in 0 until LOTTO_NUMBER_COUNT) {
                numbers.add(shuffleNumbers[i])
            }
            numbers.sort()
            return numbers
        }

    private val lottoAllNumbers: MutableList<Int>
        get() {
            val lottoNumbers = mutableListOf<Int>()
            for (number in MIN_NUMBER..MAX_NUMBER) {
                lottoNumbers.add(number)
            }
            return lottoNumbers
        }

    constructor() {
        value = randomNumbers
    }

    constructor(values: String) {
        val lottoNumbers = split(values)
        if (!isLottoSize(lottoNumbers)) {
            throw IllegalArgumentException("잘못된 로또 사이즈입니다.")
        }

        if (!isLottoNumber(toInts(lottoNumbers))) {
            throw IllegalArgumentException("잘못된 로또 번호입니다. (1~45 범위초과)")
        }

        value = toInts(lottoNumbers)
    }

    private fun isLottoNumber(numbers: List<Int>): Boolean {
        return numbers.filter { it in MIN_NUMBER..MAX_NUMBER }
                .size == LOTTO_NUMBER_COUNT
    }

    private fun isLottoSize(values: List<String>): Boolean {
        return values.size == LOTTO_NUMBER_COUNT
    }

    private fun toInts(values: List<String>): MutableList<Int> {
        return values.map { it.trim().toInt() }.toMutableList()
    }

    private fun split(lottoNumbers: String): List<String> {
        return lottoNumbers.split(",")
    }

    companion object {
        private const val MAX_NUMBER = 45
        private const val MIN_NUMBER = 1
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
