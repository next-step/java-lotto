package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoGame;
import step2.domain.LottoWinGenerator;
import step2.domain.Prizes;
import step2.service.LottoPrizeService;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

    private final InputView inputView;

    private final OutputView outputView;

    private final LottoPrizeService service;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoPrizeService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void game() {
        LottoGame lottoGame = inputGame();
        Prizes prizes = lottoGame.game(new LottoWinGenerator(getWinLotto().getNumbers()));
        outputView.showPrize(prizes);
    }

    public LottoGame inputGame() {
        LottoGame lottoGame = service.startLottoGame(inputView.start());
        inputView.nextLine();
        inputView.showInputLotto(lottoGame);
        return lottoGame;
    }

    public Lotto getWinLotto() {
        return inputView.winLotto();
    }
}
