package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winners;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;

    public void start() {
        int money = InputView.inputMoney();
        int numberOfLotto = money / LOTTO_PRICE;

        int manualSize = InputView.inputManualSize();
        List<Lotto> manualLotto = InputView.inputManualNumbers(manualSize);

        Lottos lottos = new Lottos(manualLotto, numberOfLotto);
        //Lottos lottos = new Lottos(lottoOfNumber);
        ResultView.resultLotto(manualSize, numberOfLotto, lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        Winners winners = new Winners();

        lottos.findWinners(winners, winningNumbers);

        ResultView.resultWinners(winners);
        ResultView.resultProfit(winners, money);
    }
}
