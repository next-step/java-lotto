package domain

import java.util.ArrayList

class LottoStatisticsKt(private val values: String) {

    private val winningNumbers: List<Int> = Lotto(values).lottoNumbers

    fun getNumbers(numbers: String): List<Int> {
        return LottoKt(numbers).numbers
    }

    fun getJackpot(lottoNumbers: List<Int>): JackpotKt {
        var sameCount = 0
        lottoNumbers.forEach {
            if (hasNumber(it)) {
                sameCount += 1
            }
        }
        return JackpotKt.valueOf(sameCount)
    }

    fun getJackpots(lottos: List<LottoKt>): List<JackpotKt> {
        val jackpots = ArrayList<JackpotKt>()
        lottos.forEach {
            val jackpot = getJackpot(it.numbers)
            jackpots.add(jackpot)
        }
        return jackpots
    }

    private fun hasNumber(number: Int?): Boolean {
        return winningNumbers.contains(number)
    }
}
