package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.view.InputView;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final InputView inputview;

    public LottoController(LottoMachine lottoMachine, InputView inputview) {
        this.lottoMachine = lottoMachine;
        this.inputview = inputview;
    }

    public void run() {
        int purchaseAmount = inputview.getPurchaseAmount();
        LottoTickets tickets = lottoMachine.issue(purchaseAmount);
    }
}
