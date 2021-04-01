package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        LottoFactory.setLottoStrategy(new AutoLottoStrategy());
        LottoFactory.defaultLottoNumbers();

        int buyNum = InputView.inputBuy();
        Lottos lottos = LottoFactory.lottos(buyNum);
        ResultView.printLottos(lottos);
        WinningNumbers winning = LottoFactory.winning(InputView.inputWinning(), InputView.inputBonus());
        WinningStatistics winningStatistics = LottoFactory.winningStatistics(lottos, winning);

        ResultView.printResult(winningStatistics);
        ResultView.printYield(winningStatistics.yield(buyNum));
    }

}
