package lotto.controller;

import lotto.dto.LottoPurchaseMoneyDto;
import lotto.view.InputView;

public class LottoController {

    public void get() {
        InputView inputView = new InputView(System.in);
        LottoPurchaseMoneyDto purchaseMoneyDto = new LottoPurchaseMoneyDto(inputView.inputMoney());
    }
}
