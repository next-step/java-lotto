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

        RandomNumber numberStragey = new LottoNumberStragey();
        List<LottoPaper> buyLotto = new ArrayList<>();
        int buyLottoMoney = inputView.buyLottoView();

        for (int count = 0; count < buyLottoMoney / InputView.MINIMUM_LOTTO_MONEY; count++) {
            buyLotto.add(new LottoPaper(numberStragey));
        }
        resultView.lottoNumberView(buyLotto);

        resultView.winningResult(createLottoStatstics(buyLotto, createWinningNumber()));
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
