package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class Payout {

    private static final Map<Integer, Integer> prizeMoney = new HashMap<Integer, Integer>() {
        {
            put(3, 5_000);
            put(4, 50_000);
            put(5, 1_500_000);
            put(6, 2_000_000_000);
        }
    };

    public static Integer money(Integer prize) {
        return prizeMoney.get(prize);
    }
}
