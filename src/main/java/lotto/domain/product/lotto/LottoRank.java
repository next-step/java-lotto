package lotto.domain.product.lotto;

import java.util.Arrays;

public enum LottoRank {
    SIX_MATCHES(6, 2_000_000_000, false),
    FIVE_BONUS(5, 30_000_000, true),
    FIVE_MATCHES(5, 1_500_000, false),
    FOUR_MATCHES(4, 50_000, false),
    THREE_MATCHES(3, 5_000, false),
    NO_WIN(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean needBonusNumber;

    LottoRank(int matchCount, int prize, boolean needBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.needBonusNumber = needBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean matches(int count, boolean bonus) {
        if (this == NO_WIN) return true;
        if (matchCount != count) return false;
        return needBonusNumber == bonus;
    }

    public static LottoRank of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCount, bonusMatch))
                .findFirst()
                .orElse(NO_WIN);
    }
}
