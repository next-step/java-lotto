package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.ui.InputView;

public class Controller {
    public static void main(String[] args) {
        InputView.inputPrice();

        System.out.println(LottoFactory.createLottoAutomatically().getLottoNumbers());
    }
}
