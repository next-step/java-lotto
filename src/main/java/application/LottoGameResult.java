package application;

import java.util.Arrays;

public enum LottoGameResult {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int value;
    private int reward;

    LottoGameResult(int value, int reward) {
        this.value = value;
        this.reward = reward;
    }

    public static LottoGameResult match(int number) {
        if (isInRange(number)) {
            throw new IllegalArgumentException("로또 게임 결과가 3 ~ 6 범위에서 벗어납니다.");
        }

        return Arrays.stream(LottoGameResult.values()).filter(v -> v.value == number).findFirst().get();
    }

    private static boolean isInRange(int number) {
        return number < 3 || number > 6;
    }

    public int getReward() {
        return reward;
    }
}