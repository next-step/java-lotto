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
        LottoPrice lottoPrice = new LottoPrice(inputView.price());
        int manualLottoCount = inputView.manualPurchaseCount();
        if(!lottoPrice.buyPossible(manualLottoCount)) {
            new IllegalArgumentException("돈이 부족합니다");
        }

        List<String> lists = inputView.manualNumbers(manualLottoCount);
        lottoGame.buyManualLotto(lists);
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
