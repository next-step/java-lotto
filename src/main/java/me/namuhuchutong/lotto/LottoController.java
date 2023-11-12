package me.namuhuchutong.lotto;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        int amount = inputView.showBuyPrompt();
        Numbers userNumbers = inputView.showNumbersPrompt();
        LottoSeller lottoSeller = new LottoSeller(numberGenerator);
        LottoResult lottoResult = lottoSeller.sellLotto(amount, userNumbers);
        outputView.showLottoResult(amount, lottoResult);
    }
}
