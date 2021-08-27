package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void start() {

        Money money = purchaseLottoByMoney();

        LottoPapers lottoPapers = purchaseLottoPapers(money);

        resultView.lottoNumberView(lottoPapers.getLottoPapers());

        resultView.winningResult(createLottoStatstics(lottoPapers.getLottoPapers(), createWinningNumber()));
    }

    private LottoPapers purchaseLottoPapers(Money money) {
        return LottoPapers.create(money);
    }

    private Money purchaseLottoByMoney() {
        Money money = Money.create(inputView.buyLottoView());
        resultView.purchaseLottoView(money.purchaseLottoCount());
        return money;
    }

    private WinningLottoNumber createWinningNumber() {
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(inputView.winningLottoView());
        winningLottoNumber.setBonusNumber(inputView.bonusNumberView());
        return winningLottoNumber;
    }

    private Statistics createLottoStatstics(List<LottoPaper> buyLotto, WinningLottoNumber winningLottoNumber) {
        Statistics statistics = new Statistics();
        statistics.calculateWinningResult(buyLotto, winningLottoNumber);
        return statistics;
    }


}
