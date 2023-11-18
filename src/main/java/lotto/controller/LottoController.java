package lotto.controller;

import lotto.domain.LottoAmount;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.askLottoAmount();
        LottoAmount lottoAmount = inputView.inputLottoAmount();

        int lottoCount = lottoAmount.findLottoCount();
        outputView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        outputView.printLottos(lottos);
    }
}
