package lotto.controller;

import lotto.domain.Games;
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
        String input = inputView.askPriceToPay();
        Games games = new Games(input, new RandomNumberGenerator(new Random()));
    }
}
