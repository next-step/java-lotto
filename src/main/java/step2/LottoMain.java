package step2;

import step2.domain.LottoBuyer;
import step2.domain.Lottos;
import step2.view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        final int money = InputView.plzEnterMoney();
        final LottoBuyer lottoBuyer = LottoBuyer.of(money);
        final Lottos lottos = lottoBuyer.buy();
    }
}
