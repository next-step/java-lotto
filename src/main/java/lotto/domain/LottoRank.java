package lotto.domain;

public enum LottoRank {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

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
