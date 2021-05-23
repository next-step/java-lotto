package lotto.domain.rank;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatched;
    private long amount;
    private boolean requireBonusMatched;

    LottoRank(int countOfMatched, long amount) {
        this(countOfMatched, amount, false);
    }

    LottoRank(int countOfMatched, long amount, boolean requireBonusMatched) {
        this.countOfMatched = countOfMatched;
        this.amount = amount;
        this.requireBonusMatched = requireBonusMatched;
    }


    public static LottoRank valueOf(int countOfMatched, boolean bonusMatched) {
        return Arrays.stream(values())
                .filter(item -> item.matched(countOfMatched, bonusMatched))
                .findFirst()
                .orElse(MISS);
    }

    private boolean matched(int countOfMatched, boolean bonusMatched) {
        if (this.requireBonusMatched) {
            return this.countOfMatched == countOfMatched && bonusMatched;
        }

        return this.countOfMatched == countOfMatched;
    }

    public int getCountOfMatched() {
        return countOfMatched;
    }

    public long getAmount() {
        return amount;
    }

    public boolean isRequireBonusMatched() {
        return requireBonusMatched;
    }
}
