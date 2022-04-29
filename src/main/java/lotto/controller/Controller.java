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
        System.out.println(manualLottos.toString());

//        Lottos lottos = Store.pay(price);
//
//        ResultView.printCountOfLottos(Store.countOfLottos(price));
//        ResultView.printResultOfPurchase(lottos.getLottos());
//
//        Lotto previousLotto = InputView.inputLottoOfPreviousWeek();
//        int bonusNumber = InputView.inputBonusNumber();
//
//        LottoWinner winner = lottos.calculateWinner(previousLotto, bonusNumber);
//        float yield = winner.calculateYield(price);
//
//        ResultView.printWinnerStats(winner);
//        ResultView.printYield(yield);
    }
}
