package lotto.controller;

import lotto.domain.Games;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void play() {
        Games games = lottoService.purchaseLotto(inputView.askPriceToPay());
        outputView.printPurchasedGames(games);

        LottoNumbers winner = lottoService.findWinner(inputView.askWinnerLottoNumber());
        LottoResult lottoResult = lottoService.checkResult(winner, games);

        outputView.printResult(lottoResult);
    }
}
