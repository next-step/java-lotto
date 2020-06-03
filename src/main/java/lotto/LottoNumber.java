package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> LOTTERY_NUMBERS = new HashMap<>();
    private static final int LOTTERY_MINIMUM_NUMBER = 1;
    private static final int LOTTERY_MAXIMUM_NUMBER = 45;

    static {
        for (int i = LOTTERY_MINIMUM_NUMBER; i <= LOTTERY_MAXIMUM_NUMBER; i++) {
            LOTTERY_NUMBERS.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int no) {
        if (no < LOTTERY_MINIMUM_NUMBER || no > LOTTERY_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
