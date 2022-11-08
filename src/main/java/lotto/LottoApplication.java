package lotto;

import lotto.domain.Money;
import lotto.domain.Reward;

import static lotto.view.InputView.inputBuyMoney;
import static lotto.view.InputView.inputLuckyNumber;

public class LottoApplication {
    public static void main(String[] args) {
        int money = new Money(inputBuyMoney()).getMoney();
        LottoController lotto = new LottoController();
        lotto.LottoStart(money);
    }
}
