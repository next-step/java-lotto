package step3.controller;

import static step3.view.InputView.readMoney;
import static step3.view.OutputView.print;

import step3.model.LottoBundle;
import step3.model.LottoMachine;
import step3.model.Money;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = readMoney();
        LottoBundle lottoBundle = LottoMachine.purchaseLotto(money);
        print(lottoBundle);
    }
}
