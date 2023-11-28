package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoGame;
import step2.domain.WinPrizes;
import step2.generator.Lotto45NumbersStrategy;
import step2.service.LottoPrizeService;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

import static step2.generator.Lotto45NumbersStrategy.PICK_NUMBERS;

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
        Lotto winLotto = getWinLotto();
        WinPrizes winPrizes = lottoGame.game(winLotto.getNumbers());
        outputView.showPrize(winPrizes);
    }

    public LottoGame inputGame() {
        int tryNumbers = inputView.start();
        LottoGame lottoGame = service.startLottoGame(tryNumbers);
        inputView.nextLine();
        inputView.showInputLotto(lottoGame);
        return lottoGame;
    }

    public Lotto getWinLotto() {
        return inputView.winLotto();
    }
}
