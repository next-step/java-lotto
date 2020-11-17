package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

// TODO: DTO 만들어서 inputView 와 도메인 연결하기
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

        WinningCondition condition = new WinningCondition(
                InputView.askWinningLotto(),
                InputView.askBonusBall()
        );

        Result result = lottos.getResult(condition);
        ResultView.printStatistics(result, purchaseMoney);
    }
}
