package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.util.Utility;

public class Controller {
    public static void main(String[] args) {
        int price = InputView.inputPrice();

        Lottos lottos = Store.pay(price);

        ResultView.printCountOfLottos(Store.countOfLottos(price));
        ResultView.printResultOfPurchase(lottos.getLottos());

        Integer[] previousLottoNumber = Utility.convertStringArrayToIntegerArray(Utility.split(InputView.inputLottoOfPreviousWeek()));
        Lotto previousLotto = new Lotto(previousLottoNumber);
        int bonusNumber = InputView.inputBonusNumber();

        LottoWinner winner = lottos.calculateWinner(previousLotto, bonusNumber);
        float yield = lottos.calculateYield(winner, price);

        ResultView.printWinnerStats(winner);
        ResultView.printYield(yield);
    }
}
