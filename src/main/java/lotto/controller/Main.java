package lotto.controller;

import lotto.domain.*;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Money purchaseMoney = InputAdapter.getPurchaseMoney();
        int numOfLottos = Lotto.getNumOfLottos(purchaseMoney);
        ResultView.printNumOfLottos(numOfLottos);

        Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);
        Lottos lottos = new Lottos(numOfLottos, () -> new Lotto(
                shuffler.getIntegers(Lotto.SIZE)
        ));
        ResultView.printLottos(lottos);

        WinningCondition condition = InputAdapter.getWinningCondition();
        Result result = lottos.getResult(condition);
        ResultView.printStatistics(result, purchaseMoney);
    }
}
