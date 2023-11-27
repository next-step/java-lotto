package controller;

import service.LottoPrizeService;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;

    private final OutputView outputView;

    private final LottoPrizeService service;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoPrizeService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void startGame() {
        this.inputView.start();
    }
}
