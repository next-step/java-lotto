package step2.controller;

import step2.domain.Lottos;
import step2.ui.LottoInputView;
import step2.ui.LottoOutputView;

public class LottoController {
    private final int LOTTO_AMOUNT = 1000;

    public void run() {
        int buyAmount = LottoInputView.getBuyAmount();
        int lottoCount = buyAmount / LOTTO_AMOUNT;
        Lottos lottos = new Lottos(lottoCount);
        LottoOutputView.printBuyAmount(lottoCount);

    }

}
