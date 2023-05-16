package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, ResultView resultView, LottoGame lottoGame) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoGame = lottoGame;
    }

    public void buy() {
        int price = inputView.price();
        int manualLottoCount = inputView.manualPurchaseCount();
        List<List<Integer>> lists = inputView.manualNumbers(manualLottoCount);
        LottoPrice lottoPrice = lottoGame.buyManualLotto(price, lists);
        lottoGame.buyAutoLotto(lottoPrice);

        inputView.buy(lists.size(), lottoGame.quantity()-lists.size());
        resultView.view(lottoGame.lottos());
    }

    public void result() {
        LottoScore lottoScore = lottoGame.score(
                new WinningNumbers(
                        inputView.result(),
                        inputView.bonus()
                ));
        resultView.result(lottoScore);
        resultView.rate(LottoCalculator.rate(
                lottoScore.amount(),
                lottoGame.quantity()
        ));
    }
}
