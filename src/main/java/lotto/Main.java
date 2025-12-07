package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.initLottoPrice());
        int manualCount = InputView.initManualCount();
        List<String> manualList = InputView.initManualList(manualCount);

        LottoPurchase lottoPurchase = new LottoPurchase(money, manualList);

        LottoGame lottoGame = new LottoGame(lottoPurchase);
        ResultView.printLottos(lottoGame);

        WinningLotto winningLotto = new WinningLotto(InputView.initWinningLotto(), InputView.initBonusNumber());
        LottoResult result = lottoGame.findWinner(winningLotto);
        ResultView.printResult(result, money);
    }
}
