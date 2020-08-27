package step2.view;

import step2.domain.LottoNumbers;
import step2.domain.Lottos;
import step2.domain.WiningLotto;
import step2.utils.LottoResultStatistics;

public class ResultView {
    private int inputMoneyAmount;
    private Lottos lottos;
    private LottoNumbers winnerNumbers;

    public ResultView(int inputMoneyAmount, Lottos lottos, LottoNumbers winnerNumbers) {
        this.inputMoneyAmount = inputMoneyAmount;
        this.lottos = lottos;
        this.winnerNumbers = winnerNumbers;
    }

    public void getResult() {
        System.out.println("당첨 통계");
        System.out.println("-------");

        WiningLotto winingLotto = new WiningLotto(this.lottos, this.winnerNumbers);

        LottoResultStatistics resultStatistics = LottoResultStatistics.newWinnerInventory(winingLotto.getWinner());
        resultStatistics.getWinningPriceDetails().forEach((winner, count) -> {
            System.out.println(winner.getMatchNumber() + "개 일치" + winner.getWinedMoney() + "원-" + count + "명");
        });

        System.out.println("총 수익률은 " + resultStatistics.getFinalProfit(this.inputMoneyAmount) +
                "입니다.");
    }
}
