package lotto.auto.domain;

import java.util.Arrays;

public enum Win {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    LAST_PLACE(3, 5_000),
    NOT_PLACE(0, 0);

    private int matchNumber;
    private int reward;

    public int getMatchNumber() {
        return matchNumber;
    }
    public int getReward() {
        return reward;
    }

    public static Win getWin(int matchNumber) {
        return Arrays.stream(Win.values())
                .filter(win -> win.getMatchNumber() == matchNumber)
                .findFirst()
                .orElse(Win.NOT_PLACE);
    }

    Win(int matchNumber, int reward) {
        this.matchNumber = matchNumber;
        this.reward = reward;
    }
}
