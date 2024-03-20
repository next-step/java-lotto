package lotto.model;

import java.util.List;

public class LottoMachine {

    private LottoMachine() {
    }

    public static List<Lotto> purchase(int quantity, LottoStrategy strategy) {
        return strategy.execute(quantity);
    }

}
