package lotto.domain.lotto;

import java.util.List;
import java.util.Random;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final static Random RANDOM = new Random();

    public static boolean isValid(List<Integer> values) {
        return values.stream().allMatch(LottoNumber::isValid);
    }

    public static boolean isValid(int value) {
        return (value >= LOTTO_NUMBER_MIN && value <= LOTTO_NUMBER_MAX);
    }

    public static int create() {
        return RANDOM.nextInt(LOTTO_NUMBER_MAX - LOTTO_NUMBER_MIN + 1) + LOTTO_NUMBER_MIN;
    }
}
