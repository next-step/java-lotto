package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Money purchaseMoney = InputView.askPurchaseMoney();
        int numOfLottos = Lotto.getNumOfLottos(purchaseMoney);
        ResultView.printNumOfLottos(numOfLottos);

        Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);
        Lottos lottos = new Lottos(numOfLottos, () -> new Lotto(
                shuffler.getIntegers(Lotto.SIZE)
        ));
        ResultView.printLottos(lottos);

        Lotto winningLotto = InputView.askWinningLotto();
        LottoNo bonus = InputView.askBonusBall();

        Result result = lottos.getResult(winningLotto, bonus);
        ResultView.printStatistics(result, purchaseMoney);
    }
}
