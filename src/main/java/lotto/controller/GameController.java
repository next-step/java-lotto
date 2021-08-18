package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.LottoNumberStragey;
import lotto.domain.RandomNumber;
import lotto.domain.Statistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<LottoPaper> buyLotto;
    private LottoPaper winningNumber;
    private Statistics statistics;

    public GameController() {
        buyLotto = new ArrayList<>();
        winningNumber = new LottoPaper();
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
        checkLottoStatitics(buyLottoMoney);
        resultView.winningResult(statistics);
    }

    private void checkLottoStatitics(int buyMoney) {

        for (LottoPaper lotto : buyLotto) {
            lotto.compreWinningNumber(winningNumber.getLottoNumber(), statistics);
        }

        statistics.setEarnMoneyPercentage(buyMoney);
    }

}
