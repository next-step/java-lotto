package lotto.model;

public enum LottoRank {
    FIRST(6, 2_000_000_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getMatchCount() == countOfLottoMatch;
        }
    },
    SECOND(5, 30_000_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getMatchCount() == countOfLottoMatch && countOfBonusMatch == 1;
        }
    },
    THIRD(5, 1_500_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getMatchCount() == countOfLottoMatch && countOfBonusMatch == 0;
        }
    },
    FOUR(4, 50_000){
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getMatchCount() == countOfLottoMatch;
        }
    },
    FIFTH(3, 5_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getMatchCount() == countOfLottoMatch;
        }
    };

    private final int countOfMatch;
    private final int prizeMoney;

    LottoRank(int countOfMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }


    public abstract boolean isMatch(long countOfLottoMatch, long countOfBonusMatch);
}
