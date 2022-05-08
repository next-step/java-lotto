package lotto;

import lotto.app.Lotto;
import lotto.domain.LottoVendingMachine;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(new LottoVendingMachine());
        lotto.start();
    }
}
