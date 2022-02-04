package lotto.domain;

public enum LottoRank {
    FIRST(6, 2000000000, "1등"),
    SECOND(5, 30000000, "2등(보너스 볼 일치)"),
    THIRD(5, 1500000, "3등"),
    FOURTH(4, 50000, "4등"),
    FIFTH(3, 5000, "5등");

    private final int match;
    private final int winningAmount;
    private final String rankString;

    LottoRank(final int match, final int winningAmount, String rankString) {
        this.match = match;
        this.winningAmount = winningAmount;
        this.rankString = rankString;
    }

    public static LottoRank valueOf(int match, boolean bonusBall) {
        if (match == LottoRank.SECOND.match) {
            return checkBonusBall(bonusBall);
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.match == match) {
                return lottoRank;
            }
        }

        return null;
    }

    private static LottoRank checkBonusBall(boolean bonusBall) {
        if (bonusBall) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public String getRankString() {
        return this.rankString;
    }

}
