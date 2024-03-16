package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PER_MONEY = 1_000;
    public static final LottoPaper EMPTY_LOTTO_PAPER = new LottoPaper(Collections.emptyList());

    private LottoMachine() {
    }

    public static LottoPaper purchase(int money) {
        int quantity = calculate(money);
        if (quantity == 0) {
            return EMPTY_LOTTO_PAPER;
        }

        return new LottoPaper(prepare(quantity));
    }

    private static int calculate(int money) {
        return money / LOTTO_PER_MONEY;
    }

    private static List<Lotto> prepare(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            result.add(new Lotto(LottoNumbers.selectRandomLottoNumbers()));
        }

        return result;
    }
    
}
