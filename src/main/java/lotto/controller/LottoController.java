package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGame lottoGame;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView, ResultView resultView, LottoGame lottoGame, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoGame = lottoGame;
        this.lottoGenerator = lottoGenerator;
    }

    public void buy() {
        LottoPrice lottoPrice = new LottoPrice(inputView.price());
        int manualLottoCount = inputView.manualPurchaseCount();

        validatePurchase(lottoPrice, manualLottoCount);
        List<String> lists = inputView.manualNumbers(manualLottoCount);

        lottoGame.buyLottos(lottoGenerator.manual(lists));
        lottoGame.buyLottos(lottoGenerator.auto(lottoPrice.lottoCount() - manualLottoCount));
        inputView.buy(manualLottoCount, lottoPrice.lottoCount() - manualLottoCount);
    }

    public void result() {
        LottoScore lottoScore = lottoGame.score(
                new WinningNumbers(
                        inputView.result(),
                        inputView.bonus()
                ));
        resultView.view(lottoGame.lottos());
        resultView.result(lottoScore);
        resultView.rate(LottoCalculator.rate(
                lottoScore.amount(),
                lottoGame.quantity()
        ));
    }

    private void validatePurchase(LottoPrice lottoPrice, int manualLottoCount) {
        if (!lottoPrice.buyPossible(manualLottoCount)) {
            throw new IllegalArgumentException("돈이 부족합니다");
        }
    }
}
