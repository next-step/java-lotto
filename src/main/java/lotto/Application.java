package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    private PurChasedLotto purChasedLotto;
    private LottoMoney lottoMoney;

    public void run() {
        purChaseLotto();
        calculateWinningLotto();
    }

    private void purChaseLotto() {
        lottoMoney = new LottoMoney(InputView.readLottoMoney());

        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(autoLottoGenerator);

        purChasedLotto = lottoPurchaser.purchaseLotto(lottoMoney);
        OutputView.printPurchasedResult(purChasedLotto);
    }

    private void calculateWinningLotto() {
        List<Integer> integers = InputView.readWinningLotto();
        int bonusBall = InputView.readBonusBall();

        WinningLotto winningLotto = new WinningLotto(integers, bonusBall);
        WinningCalculator winningCalculator = new WinningCalculator();

        WinningResult winningResult = winningCalculator.calculate(winningLotto, purChasedLotto);
        OutputView.printWinningResult(WinningResponse.of(winningResult, lottoMoney));
    }
}
