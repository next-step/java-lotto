package step2.domain;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int countOfMatch;
    private final int reward;

    LottoRank(int countOfMatch, int reward) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
    }

    private static LottoRank getLottoRank(int countOfMatch, LottoRank lottoRank) {
        if (lottoRank.countOfMatch == countOfMatch) {
            return lottoRank;
        }
        return NONE;
    }

    public int reward() {
        return reward;
    }

    public int countOfMatch() {
        return countOfMatch;
    }
}
