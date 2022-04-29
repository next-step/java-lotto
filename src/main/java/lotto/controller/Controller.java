package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Controller {
    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int countOfManualLotto = InputView.inputCountOfManualLotto(price);

        Lottos lottos = Store.pay(price);

        ResultView.printCountOfLottos(Store.countOfLottos(price));
        ResultView.printResultOfPurchase(lottos.getLottos());

        Lotto previousLotto = InputView.inputLottoOfPreviousWeek();
        int bonusNumber = InputView.inputBonusNumber();

        LottoWinner winner = lottos.calculateWinner(previousLotto, bonusNumber);
        float yield = winner.calculateYield(price);

        ResultView.printWinnerStats(winner);
        ResultView.printYield(yield);
    }
}
