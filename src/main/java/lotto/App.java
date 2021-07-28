package lotto;

import lotto.service.LottoOffice;
import lotto.domain.lotto.LottoBunch;
import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class App {

    public static void main(String[] args) {
        int money = InputView.inputPurchaseMoney();
        LottoOffice lottoOffice = new LottoOffice(Money.of(money));
        LottoBunch lottoBunch = lottoOffice.purchase();
        ResultView.printLottos(lottoBunch);
    }
}