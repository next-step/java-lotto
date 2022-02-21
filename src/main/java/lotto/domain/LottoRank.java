package lotto.domain;

@FunctionalInterface
interface Prize {

    boolean checkWithBonus(int matchCount, boolean bonusMatch);
}

public enum LottoRank {
    FIFTH(5_000, "3개 일치", (matchCount, bonusMatch) -> matchCount == 3),
    FOURTH(50_000, "4개 일치", (matchCount, bonusMatch) -> matchCount == 4),
    THIRD(1_500_000, "5개 일치", ((matchCount, bonusMatch) -> matchCount == 5 && !bonusMatch)),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치",
        ((matchCount, bonusMatch) -> matchCount == 5 && bonusMatch)),
    FIRST(2_000_000_000, "6개 일치", (matchCount, bonusMatch) -> matchCount == 6);

    private final int winningAmount;
    private final String rankState;
    private final Prize prize;

    LottoRank(final int winningAmount, final String rankState, final Prize prize) {
        this.winningAmount = winningAmount;
        this.rankState = rankState;
        this.prize = prize;
    }

    public static LottoRank valueOf(int match, boolean bonusBall) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.prize.checkWithBonus(match, bonusBall)) {
                return lottoRank;
            }
        }
        return null;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public String getRankState() {
        return this.rankState;
    }

}
