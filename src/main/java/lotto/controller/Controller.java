package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int countOfManualLotto = InputView.inputCountOfManualLotto(price);
        List<Lotto> manualLottos = InputView.inputManualLottos(countOfManualLotto);

        Lottos myLottos = Lottos.buyLottos(manualLottos, price);

        ResultView.printCountOfLottos(Lottos.countOfLottos(price), countOfManualLotto);
        ResultView.printResultOfPurchase(myLottos.getLottos());

        LottoWinningCondition winningCondition = InputView.inputWinningConditionOfLotto();

        LottoWinner winner = myLottos.calculateWinner(winningCondition);
        float yield = winner.calculateYield(price);

        ResultView.printWinnerStats(winner);
        ResultView.printYield(yield);
    }
}
