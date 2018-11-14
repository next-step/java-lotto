package domain

import java.util.ArrayList

class LottoStatisticsKt(values: String) {

    private val winningNumbers: List<Int> = Lotto.manual(values).lottoNumbers

    fun getNumbers(numbers: String): List<Int> {
        return LottoKt.manual(numbers).numbers
    }

    fun getJackpot(lottoNumbers: List<Int>): RankKt {
        var sameCount = 0
        lottoNumbers.forEach {
            if (hasNumber(it)) {
                sameCount += 1
            }
        }
        return RankKt.valueOf(sameCount)
    }

    fun getJackpots(lottos: List<LottoKt>): List<RankKt> {
        val jackpots = ArrayList<RankKt>()
        lottos.forEach {
            val jackpot = getJackpot(it.numbers)
            jackpots.add(jackpot)
        }
        return jackpots
    }

    private fun hasNumber(number: Int?): Boolean {
        return winningNumbers.contains(number)
    }

    fun match(lottos: MutableList<LottoKt>): LottoResultKt {
        val jackpots = getJackpots(lottos)
        return LottoResultKt(jackpots)
    }
}
