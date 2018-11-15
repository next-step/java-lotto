package domain

import java.util.ArrayList

class LottoStatisticsKt(values: String, private val bonusNumber: Int) {
    private val winningNumbers: LottoKt = LottoKt.manual(values)

    fun match(lottos: MutableList<LottoKt>): LottoResultKt {
        return LottoResultKt(getRanks(lottos))
    }

    private fun getRanks(lottos: List<LottoKt>): List<RankKt> {
        val ranks = ArrayList<RankKt>()
        lottos.forEach {
            ranks.add(it.getMatchRank(winningNumbers, bonusNumber))
        }
        return ranks
    }
}
