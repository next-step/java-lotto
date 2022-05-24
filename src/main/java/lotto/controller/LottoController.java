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

        Lottos lottos = Lottos.createManualLottos(manualLotto, numberOfLotto);
        ResultView.resultLotto(manualSize, numberOfLotto, lottos);

        WinningNumbers winningNumbers = WinningNumbers.of(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        Winners winners = Winners.of();
        winners.findWinners(lottos, winningNumbers);

        ResultView.resultWinners(winners);
        ResultView.resultProfit(winners, money);
    }
}
