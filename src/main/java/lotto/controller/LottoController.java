package lotto.controller;

import lotto.domain.LottoGame;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.NumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.numberGenerator = new LottoNumberGenerator();
    }

    public void play() {
        LottoGame lottoGame = LottoGame.init(inputView.inputAmount());
        lottoGame.buyLotto(numberGenerator);
    }
}
