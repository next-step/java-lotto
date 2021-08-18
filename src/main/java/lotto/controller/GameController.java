package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberStragey;
import lotto.domain.Statistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<LottoNumber> buyLotto;
    private LottoNumber winningNumber;
    private Statistics statistics;

    public GameController() {
        buyLotto = new ArrayList<>();
        winningNumber = new LottoNumber();
        statistics = new Statistics();
    }

    public void init() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int buyLottoMoney = inputView.buyLottoView();

        for(int count = 0; count < buyLottoMoney / InputView.MINIMUM_LOTTO_MONEY; count++) {
            buyLotto.add(new LottoNumber(new LottoNumberStragey()));
        }

        resultView.lottoNumberView(buyLotto);
        winningNumber.setWinningNumber(inputView.winningLottoView());
        checkLottoStatitics(buyLottoMoney);
        resultView.winningResult(statistics);
    }

    private void checkLottoStatitics(int buyMoney) {

        for (LottoNumber lotto : buyLotto) {
            lotto.compreWinningNumber(winningNumber.getLotto(), statistics);
        }

        statistics.setEarnMoneyPercentage(buyMoney);
    }

}
