package step4.app;

import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        Money money = new Money(InputView.receiveMoney());
        Lottos lottos = getLottos(money);
        WinningNumbers winningNumbers = getWinningNumbers();
        LottoResults lottoResults = new LottoResults(lottos.collectRank(winningNumbers));
        ResultView.printWinningCountStatistics(lottoResults.calculateWinningCountStatistics());
        ResultView.printYield(lottoResults.calculateYield(money));
    }

    private static Lottos getLottos(Money money) {
        int lottoPurchaseCount = money.calculateLottoPurchaseCount();
        ResultView.printLottoPurchaseCount(lottoPurchaseCount);
        Lottos lottos = new Lottos(LottoFactory.create(lottoPurchaseCount));
        ResultView.printLottos(lottos);
        return lottos;
    }

    private static WinningNumbers getWinningNumbers() {
        String winningNumberLine = InputView.receiveWinningNumberLine();
        int bonusBall = InputView.receiveBonusBall();
        return new WinningNumbers(LottoUtils.splitWinningNumberLineAndReturnLottoNumbers(winningNumberLine), bonusBall);
    }

}
