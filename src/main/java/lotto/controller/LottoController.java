package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        int lottoPrice = inputView.getLottoPrice();
        LottoGame game = LottoGame.getInstance();

        Lottos lottos = game.buy(lottoPrice);

        resultView.priceLottoStatus(lottos);
        String lastWinningNumber = inputView.getLastWinningNumber();
        Lotto winnerLotto = inputView.getWinnerLottoNumbers(lastWinningNumber);

        LottoNum bonusNumber = inputView.getBonusNumber();
        LottoResult result = LottoResult.getLottoResult(lottos, winnerLotto, bonusNumber);

        resultView.printLottoResult(result);
    }
}
