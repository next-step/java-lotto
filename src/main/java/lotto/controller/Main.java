package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.Shuffler;

public class Main {
    public static void main(String[] args) {
        Money lottoPrice = LottoPriceMoney.getInstance();
        Money purchaseMoney = InputView.askPurchaseMoney();
        int numOfLottos = (int) purchaseMoney.divide(lottoPrice);
        ResultView.printNumOfLottos(numOfLottos);

        Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);
        Lottos lottos = Lottos.create(numOfLottos, () -> new Lotto(
                shuffler.getIntegers(Lotto.SIZE)
        ));
        ResultView.printLottos(lottos);

        Lotto winningLotto = InputView.askWinningLotto();
        Result result = lottos.getResult(winningLotto);
        ResultView.printStatistics(result, purchaseMoney);
    }
}
