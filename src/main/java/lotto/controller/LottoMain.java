package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;


public class LottoMain {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int numberOfLotto = money / LOTTO_PRICE;
        int manualSize = InputView.inputManualSize();
        List<Lotto> manualLotto = InputView.inputManualNumbers(manualSize);

        Lottos lottos = new Lottos(manualLotto, numberOfLotto);
        ResultView.resultLottoNumber(manualSize, numberOfLotto, lottos);

        Winners winners = new Winners(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        lottos.findWinners(winners);

        ResultView.resultWinners(winners);
        ResultView.resultProfit(winners, money);
    }


}
