package lotto;

import lotto.model.Lotto;
import lotto.util.LotteryNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static int PRICE_PER_ONE = 1000;

    public List<Lotto> buy(int money) {
        List<Lotto> results = new ArrayList<>();
        for (int i = 0, len = money / PRICE_PER_ONE; i < len; i++) {
            results.add(new Lotto(LotteryNumberGenerator.generate()));
        }

        return results;
    }
}
