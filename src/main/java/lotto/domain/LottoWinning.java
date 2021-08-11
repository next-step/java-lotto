package lotto.domain;

import java.util.Arrays;

public enum LottoWinning {
    FAIL(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int reward;

    LottoWinning(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoWinning getWinningStatus(int matchCount) {
        LottoWinning winning = Arrays.stream(LottoWinning.values())
                                    .filter(s -> s.getMatchCount() == matchCount)
                                    .findAny()
                                    .orElse(null);
        if (winning != null) {
            return winning;
        }
        return FAIL;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

}
