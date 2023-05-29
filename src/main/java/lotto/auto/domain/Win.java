package lotto.auto.domain;

import java.util.Arrays;

public enum Win {
    FIRST(6, false,2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4, false,50_000),
    FIFTH(3, false,5_000),
    MISS(0, false,0);

    private int matchNumber;
    private boolean isMatchBonusBall;
    private int reward;

    public int getMatchNumber() {
        return matchNumber;
    }
    public boolean getMatchBonusNBall() {
        return isMatchBonusBall;
    }
    public int getReward() {
        return reward;
    }

    public static Win getWin(int matchNumber, boolean isMatchBonusBall) {
        return Arrays.stream(Win.values())
                .filter(win -> win.getMatchNumber() == matchNumber)
                .filter(win -> win.getMatchBonusNBall() == isMatchBonusBall)
                .findFirst()
                .orElse(Win.MISS);
    }
    Win(int matchNumber, boolean isMatchBonusBall, int reward) {
        this.matchNumber = matchNumber;
        this.isMatchBonusBall = isMatchBonusBall;
        this.reward = reward;
    }
}
