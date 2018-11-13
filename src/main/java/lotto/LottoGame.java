package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static int PRICE_PER_ONE = 1000;

    public List<String> buy(int money) {
        List<String> results = new ArrayList<>();
        for (int i = 0, len = money / PRICE_PER_ONE; i < len; i++) {
            results.add("1");
        }

        return results;
    }
}
