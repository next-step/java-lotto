package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<LottoPaper> buyLotto;
    private WinningLottoNumber winningNumber;
    private Statistics statistics;

    public GameController() {
        buyLotto = new ArrayList<>();
        winningNumber = new WinningLottoNumber();
        statistics = new Statistics();
    }

    public void init() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomNumber numberStragey = new LottoNumberStragey();
        int buyLottoMoney = inputView.buyLottoView();

        for(int count = 0; count < buyLottoMoney / InputView.MINIMUM_LOTTO_MONEY; count++) {
            buyLotto.add(new LottoPaper(numberStragey));
        }

        resultView.lottoNumberView(buyLotto);
        winningNumber.setWinningNumber(inputView.winningLottoView());

        resultView.winningResult(statistics);
    }


}
