package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        // 로또를 구매할 수를 입력한다
        BuyNumber buyNumber = new BuyNumber(InputView.inputBuy(), InputView.inputManualSize());
        // 구매수를 바탕으로 로또를 생성한다
        Lottos lottos = LottoFactory.mixLottos(buyNumber,
                InputView.inputManualLotto(buyNumber.getManualNumber()));
        // 로또 구매 결과를 출력한다
        ResultView.printBuySize(buyNumber);
        ResultView.printLottos(lottos);
        // 당첨번호를 입력해서 당첨 통계를 계산한다.
        WinningNumbers winning = LottoFactory.winning(InputView.inputWinning(), InputView.inputBonus());
        WinningStatistics winningStatistics = LottoFactory.winningStatistics(lottos, winning);
        // 결과 통계치를 출력한다.
        ResultView.printResult(winningStatistics);
        ResultView.printYield(winningStatistics.yield(buyNumber.getTotalNumber()));
    }

}
