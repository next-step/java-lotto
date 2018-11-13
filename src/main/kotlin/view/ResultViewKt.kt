package view

import domain.LottoKt
import domain.LottoResultKt

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
        for (jackpot in lottoResult.jackpot) {
            val matchCount = lottoResult.matchCount(jackpot)
            sb.append(String.format("%d개 일치 (%d원) - %d개", jackpot.matchNumber, jackpot.prizeMoney, matchCount))
            sb.append("\n")
        }
        println(sb.toString())
    }

    private fun showRate(lottoResult: LottoResultKt) {
        println(String.format("총 수익률은 %.2f입니다.", lottoResult.calculatorRate()))
    }
}
