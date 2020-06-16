package step2;

import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buy(Money money) {
        return Collections.nCopies(money.divide(LOTTO_PRICE),Lotto.buy());
    }
}
