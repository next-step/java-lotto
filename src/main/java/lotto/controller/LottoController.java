package lotto.controller;

import lotto.domain.Games;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        int money = inputView.askPriceToPay();
        Games games = new Games(money);

        outputView.printPurchasedGames(games);

        LottoNumbers winner = new LottoNumbers(inputView.askWinnerLottoNumber());
        LottoResult lottoResult = new LottoResult(winner, games);

        outputView.printResult(lottoResult);
    }
}
