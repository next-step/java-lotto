package step2_2;

import static step2_2.InputView.readMoney;
import static step2_2.OutputView.printLottoBundle;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = readMoney();
        LottoBundle lottoBundle = LottoMachine.purchaseLottos(money);
        printLottoBundle(lottoBundle);
    }
}
