package step3.controller;

import step3.model.Lotto;
import step3.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        Lotto lotto = InputView.readLotto();
    }
}
