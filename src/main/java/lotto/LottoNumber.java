package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> LOTTERY_NUMBERS = new HashMap<>();
    private static final int LOTTERY_MINIMUM_NUMBER = 1;
    private static final int LOTTERY_MAXIMUM_NUMBER = 45;

    static {
        for (int i = LOTTERY_MINIMUM_NUMBER; i <= LOTTERY_MAXIMUM_NUMBER; i++) {
            LOTTERY_NUMBERS.put(i, new LottoNumber(i));
        }
    }

    private final int no;

    public LottoNumber(int no) {
        if (no < LOTTERY_MINIMUM_NUMBER || no > LOTTERY_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.no = no;
    }

    public static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }
        return of(Integer.parseInt(value.trim()));
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(LOTTERY_NUMBERS.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return String.valueOf(no);
    }
}
