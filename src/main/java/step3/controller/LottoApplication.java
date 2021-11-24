package step3.controller;

import step3.model.Money;
import step3.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = InputView.readMoney();
    }
}
