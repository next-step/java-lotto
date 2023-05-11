package lottoauto.model;

import java.util.Arrays;

public enum WinningReward {
    NONE(0, 0, "0개 일치"),
    MATCH_1(1, 0, "1개 일치"),
    MATCH_2(2, 0, "2개 일치"),
    MATCH_3(3, 5000, "3개 일치 (5_000원)"),
    MATCH_4(4, 50000, "4개 일치 (50_000원)"),
    MATCH_5(5, 1500000, "5개 일치 (1_500_000원)"),
    MATCH_5_BONUS(6, 30000000, "5개 일치, 보너스 숫자 일치 (30_000_000원)"),
    MATCH_6(6, 2000000000, "6개 일치 (2_000_000_000원)");

    private final int match;
    private final int reward;
    private final String printString;

    WinningReward(int match, int reward, String printString) {
        this.match = match;
        this.reward = reward;
        this.printString = printString;
    }

    public int getMatch() {
        return match;
    }

    public int getReward() {
        return reward;
    }

    public String getPrintString() {
        return printString;
    }

    public static WinningReward findRewardByMatches(int match) {
        return Arrays.stream(WinningReward.values())
                .filter(x -> x.match == match)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 수가 없습니다."));
    }
}
