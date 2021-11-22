package step2_2;

import static step2_2.InputView.readLotto;
import static step2_2.InputView.readMoney;
import static step2_2.OutputView.printLottoBundle;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = readMoney();
        LottoBundle lottoBundle = new LottoBundle(money);
        printLottoBundle(lottoBundle);

        Lotto winner = readLotto();
        LottoResult lottoResult = lottoBundle.getLottoResult(winner);
    }
}
