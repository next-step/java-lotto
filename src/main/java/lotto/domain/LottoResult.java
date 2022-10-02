package lotto.domain;

import java.util.Map;

public class LottoResult {

    public static final int FIRST_PRIZE = 2000000000;
    public static final int FIRST = 6;
    public static final int SECOND_PRIZE = 1500000;
    public static final int SECOND = 5;
    public static final int THIRD_PRIZE = 50000;
    public static final int THIRD = 4;
    public static final int FOURTH_PRIZE = 5000;
    public static final int FOURTH = 3;

    private final Map<Integer, Integer> value;

    public LottoResult(Map<Integer, Integer> lottoResult) {
        this.value = lottoResult;
    }

    public int getFirstCount() {
        return value.getOrDefault(FIRST, 0);
    }

    public int getSecondCount() {

        return value.getOrDefault(SECOND, 0);
    }

    public int getThirdCount() {
        return value.getOrDefault(THIRD, 0);
    }

    public int getFourthCount() {
        return value.getOrDefault(FOURTH, 0);
    }

}
