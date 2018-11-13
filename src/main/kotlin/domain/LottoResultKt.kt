package domain

import java.math.RoundingMode
import java.util.Arrays.asList

class LottoResultKt(private val jackpots: List<JackpotKt>) {

    val jackpot: List<JackpotKt>
        get() = asList(JackpotKt.SAME_3_NUMBERS,
                JackpotKt.SAME_4_NUMBERS,
                JackpotKt.SAME_5_NUMBERS,
                JackpotKt.SAME_6_NUMBERS)

    private val paidLotto: Int
        get() = Lotto.PRICE * jackpots.size

    private val totalPrizeMoney: Int
        get() {
            var totalPrizeMoney = 0
            for (jackpot in jackpot) {
                totalPrizeMoney += jackpot.getTotalPrizeMoney(matchCount(jackpot))
            }
            return totalPrizeMoney
        }

    fun matchCount(selectedJackpot: JackpotKt): Int {
        return jackpots.filter { jackpot -> jackpot == selectedJackpot }
                .count()
    }

    fun calculatorRate(): Double {
        val rate = totalPrizeMoney.toDouble() / paidLotto
        return rate.toBigDecimal()
                .setScale(2, RoundingMode.DOWN)
                .toDouble()
    }
}
