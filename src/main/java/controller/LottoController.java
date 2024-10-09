package controller;

import lotto.domain.Lotto;
import lotto.service.LottoGame;
import view.InputView;
import view.ResultView;

import java.util.List;

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

        List<Lotto> lottos = game.getLottos(game.getLottoCount(lottoPrice));

        resultView.priceLottoResult(lottos);
    }
}
