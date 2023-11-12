package lotto.controller;

import lotto.domain.InputValidator;
import lotto.ui.InputView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        inputValidator.validatePurchasePrice(inputView.inputPrice());
    }
}
