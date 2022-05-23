package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Winners;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;

    public void start() {
        int money = InputView.inputMoney();
        int lottoOfNumber = money / LOTTO_PRICE;
        Lottos lottos = new Lottos(lottoOfNumber);
        ResultView.resultLotto(lottoOfNumber, lottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        Winners winners = new Winners();

        lottos.findWinners(winners, winningNumbers);

        ResultView.resultWinners(winners);
        ResultView.resultProfit(winners, money);
    }
}
