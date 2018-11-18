package lotto;

import lotto.model.Lotto;
import lotto.util.LotteryNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public List<Lotto> buy(int money) {
        List<Lotto> results = new ArrayList<>();
        for (int i = 0, len = money / LottoConstants.PRICE_PER_ONE; i < len; i++) {
            results.add(Lotto.from(LotteryNumberGenerator.generate()));
        }
        return results;
    }
}
