package step2_2;

import static step2_2.InputView.readLotto;
import static step2_2.InputView.readMoney;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = readMoney();
        LottoBundle lottoBundle = LottoMachine.purchaseLottos(money);

        Lotto winner = readLotto();
    }
}
