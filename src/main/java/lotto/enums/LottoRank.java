package lotto.enums;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NO_RANK(0, 0);

    private final int matchCount;
    private final int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        for (var rank : values()) {
            if (SECOND.matchCount == matchCount) {
                return matchWithBonusNumber(matchBonus);
            }

            if (rank.matchCount == matchCount) {
                return rank;
            }
        }

        return NO_RANK;
    }

    private static LottoRank matchWithBonusNumber(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }

        return THIRD;
    }

    public String getDescription() {
        if (SECOND == this) {
            return String.format("%s개 일치, 보너스 볼 일치 (%s원)", matchCount, reward);
        }

        return String.format("%s개 일치 (%s원)", matchCount, reward);
    }

    public int getReward() {
        return reward;
    }
}
