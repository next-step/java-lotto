package lotto;

import lotto.domain.Money;

import static lotto.view.InputView.inputBuyMoney;

public class LottoApplication {
    public static void main(String[] args) {
        int money = new Money(inputBuyMoney()).getMoney();
        LottoController lottoController = new LottoController();
        lottoController.lottoStart(money);
    }
}
