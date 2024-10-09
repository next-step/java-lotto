package controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;
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

        resultView.priceLottoStatus(lottos);
        String lastWinningNumber = inputView.getLastWinningNumber();
        Lotto winnerLotto = game.getWinnerLotto(lastWinningNumber);

        LottoResult result = LottoResult.getLottoResult(lottos, winnerLotto, LOTTO_PRICE);

        resultView.printLottoResult(result);
    }
}
