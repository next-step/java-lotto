package step2.controller;

import step2.domain.LottoMachine;
import step2.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoView = new LottoView();
        this.lottoMachine = new LottoMachine();
    }

    public void LottoProcess() {
        int money = lottoView.paymentMoney();
        lottoMachine.createLotto(money);
    }
}
