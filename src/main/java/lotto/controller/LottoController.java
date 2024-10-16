package lotto.controller;

import lotto.domain.Game;
import lotto.domain.Games;
import lotto.domain.LottoResult;
import lotto.domain.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.Random;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String moneyInput = inputView.askPriceToPay();
        Games games = new Games(moneyInput, new RandomNumberGenerator(new Random()));
        outputView.printPurchasedGames(games);

        Game winner = new Game(inputView.askWinnerLottonumber());
        LottoResult lottoResult = new LottoResult(winner, games);

        outputView.printResult(lottoResult);
    }
}
