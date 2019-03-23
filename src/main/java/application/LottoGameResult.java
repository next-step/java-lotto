package application;

import java.util.Arrays;

public enum LottoGameResult {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private static final int LOTTO_MIN_VALUE = 3;
    private static final int LOTTO_MAX_VALUE = 6;
    private int value;
    private int reward;

    LottoGameResult(int value, int reward) {
        this.value = value;
        this.reward = reward;
    }

    public static LottoGameResult match(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException("로또 게임 결과가 3 ~ 6 범위에서 벗어납니다.");
        }

        return Arrays.stream(LottoGameResult.values()).filter(v -> v.value == number).findFirst().get();
    }

    public static int multiple(int number, int count) {
        return match(number).reward * count;
    }

    public int getValue() {
        return value;
    }

    public static boolean isInRange(int number) {
        return number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE;
    }

    public int getReward() {
        return reward;
    }
}