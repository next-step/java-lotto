package domain

import java.math.RoundingMode
import java.util.Arrays.asList

class LottoResultKt(private val ranks: List<RankKt>) {

    val rank: List<RankKt>
        get() = asList(RankKt.SAME_3_NUMBERS,
                RankKt.SAME_4_NUMBERS,
                RankKt.SAME_5_NUMBERS,
                RankKt.SAME_6_NUMBERS)

    private val paidLotto: Int
        get() = Lotto.PRICE * ranks.size

    private val totalPrizeMoney: Int
        get() {
            var totalPrizeMoney = 0
            for (jackpot in rank) {
                totalPrizeMoney += jackpot.getTotalPrizeMoney(matchCount(jackpot))
            }
            return totalPrizeMoney
        }

    fun matchCount(selectedRank: RankKt): Int {
        return ranks.filter { jackpot -> jackpot == selectedRank }
                .count()
    }

    fun calculatorRate(): Double {
        val rate = totalPrizeMoney.toDouble() / paidLotto
        return rate.toBigDecimal()
                .setScale(2, RoundingMode.DOWN)
                .toDouble()
    }
}
