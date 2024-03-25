package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 1_500_000),
    THIRD("3등", 4, 50_000),
    FOURTH("4등", 3, 5_000),
    NO_MATCH("미당첨", 0, 0);

    private String ranking;
    private int matchCount;
    private int reward;

    LottoRank(String ranking, int matchCount, int reward) {
        this.ranking = ranking;
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public String getRanking() {
        return ranking;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank getLottoRank(int matchCount) {
        return Arrays.stream(values())
            .filter(lottoRank -> lottoRank.matchCount == matchCount)
            .findFirst()
            .orElseGet(() -> LottoRank.NO_MATCH);
    }
}
