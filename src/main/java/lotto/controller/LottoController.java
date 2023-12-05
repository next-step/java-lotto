package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoWinGenerator;
import lotto.domain.Prizes;
import lotto.generator.Lotto45NumbersMakeStrategy;
import lotto.service.LottoPrizeService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;

    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void game() {
        LottoGame lottoGame = inputGame();
        Prizes prizes = lottoGame.game(new LottoWinGenerator(getWinLotto().getNumbers()));
        outputView.showPrize(prizes);
    }

    public LottoGame inputGame() {
        LottoGame lottoGame = LottoGame.create(inputView.gameStart(), new Lotto45NumbersMakeStrategy());
        inputView.showInputLotto(lottoGame);
        return lottoGame;
    }

    public Lotto getWinLotto() {
        return inputView.winLotto();
    }
}
