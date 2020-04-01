package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        playLotto();
    }

    public static void playLotto() {
        int paidMoney = InputView.getMoney();

        Lotto lotto = issueLotto(paidMoney);
        ResultView.printIssuedLotto(lotto);
    }

    public static Lotto issueLotto(int price) {
        return new Lotto(price / LOTTO_PRICE);
    }
}
