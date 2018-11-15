package view

import domain.LottoKt
import domain.LottoResultKt
import domain.RankKt

object ResultViewKt {

    fun showBoughtLottos(lottos: List<LottoKt>) {
        howManyBoughtLotto(lottos.size)

        val sb = StringBuilder()
        for (lotto in lottos) {
            sb.append(lotto.toString())
            sb.append("\n")
        }
        println(sb.toString() + "\n")
    }

    private fun howManyBoughtLotto(sizeOfLotto: Int) {
        println(String.format("%d개를 구매했습니다.", sizeOfLotto))
    }

    fun showResult(lottoResult: LottoResultKt) {
        println("당첨 통계\n---------")
        showMatches(lottoResult)
        showRate(lottoResult)
    }

    private fun showMatches(lottoResult: LottoResultKt) {
        val sb = StringBuilder()
        for (rank in lottoResult.rank) {
            val matchCount = lottoResult.matchCount(rank)
            sb.append(String.format(matchedFormat(rank), rank.matchNumber, rank.prizeMoney, matchCount))
            sb.append("\n")
        }
        println(sb.toString())
    }

    private fun matchedFormat(rank: RankKt): String {
        var matchedFormat = "%d개 일치 (%d원) - %d개"
        if (rank == RankKt.SECOND) {
            matchedFormat = "%d개 일치, 보너스 볼 일치 (%d원) - %d개"
        }
        return matchedFormat
    }

    private fun showRate(lottoResult: LottoResultKt) {
        println(String.format("총 수익률은 %.2f입니다.", lottoResult.calculatorRate()))
    }
}
