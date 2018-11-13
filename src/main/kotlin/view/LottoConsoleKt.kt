package view

import domain.*

object LottoConsoleKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val money = InputView.getInputNumber("구매금액을 입력해 주세요.")
        val lottoGame = LottoGameKt()
        lottoGame.buyLotto(money)
        val lottos = lottoGame.lottos
        ResultViewKt.showBoughtLottos(lottos)

        val lottoWinningNumbers = InputViewKt.getInputString("지난 주 당첨 번호를 입력해 주세요.")

        val lottoStatistics = LottoStatisticsKt(lottoWinningNumbers)
        val lottoResult = lottoStatistics.match(lottos)
        ResultViewKt.showResult(lottoResult)
    }
}
