package step4.app;

import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        Lottos lottos = getLottos();
        WinningNumbers winningNumbers = getWinningNumbers();
        LottoResults lottoResults = new LottoResults(lottos.collectRank(winningNumbers));
        ResultView.printWinningCountStatistics(lottoResults.calculateWinningCountStatistics());
        ResultView.printYield(lottoResults.calculateYield(lottos));
    }

    private static Lottos getLottos() {
        Money money = new Money(InputView.receiveMoney());
        int lottoPurchaseCount = money.calculateLottoPurchaseCount();
        ResultView.printLottoPurchaseCount(lottoPurchaseCount);
        Lottos lottos = new Lottos(LottoFactory.createsByLottoPurchaseCount(lottoPurchaseCount));
        ResultView.printLottos(lottos);
        return lottos;
    }

    private static WinningNumbers getWinningNumbers() {
        String winningNumberLine = InputView.receiveWinningNumberLine();
        int bonusBall = InputView.receiveBonusBall();
        return new WinningNumbers(LottoUtils.splitWinningNumberLineAndReturnLottoNumbers(winningNumberLine), bonusBall);
    }

}
