package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.util.Utility;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        int price = InputView.inputPrice();

        List<Lotto> lottos = Store.pay(price);

        ResultView.printCountOfLottos(Store.countOfLottos(price));
        ResultView.printResultOfPurchase(lottos);

        Integer[] previousLottoNumber = Utility.convertStringArrayToIntegerArray(Utility.split(InputView.inputLottoOfPreviousWeek()));
        Lotto previousLotto = new Lotto(previousLottoNumber);

        LottoStatistics lottoStatistics = LottoStatistics.of();
        LottoWinner winner = lottoStatistics.calculateStats(lottos, previousLotto);
        float yield = lottoStatistics.calculateYield(winner, price);

        ResultView.printWinnerStats(winner);
        ResultView.printYield(yield);
    }
}
