package lotto.domain;

import lotto.generic.Money;

import java.util.Arrays;
import java.util.Objects;

public enum LottoStatus {
    NOTHING(0, BonusNumberStatus.NOT_APPLY,0L),
    FIFTH(3, BonusNumberStatus.NOT_APPLY,5000L),
    FOURTH(4, BonusNumberStatus.NOT_APPLY,50000L),
    THIRD(5, BonusNumberStatus.MISS,1500000L),
    SECOND(5, BonusNumberStatus.MATCH,30000000L),
    FIRST(6, BonusNumberStatus.NOT_APPLY,2000000000L);

    private final int hitCount;

    private final BonusNumberStatus bonusNumberStatus;

    private final Money winningAmount;

    LottoStatus(final int hitCount, BonusNumberStatus bonusNumberStatus, final long winningAmount) {
        this.hitCount = hitCount;
        this.bonusNumberStatus = bonusNumberStatus;
        this.winningAmount = Money.wons(winningAmount);
    }

    public static LottoStatus find(final int hitCount, BonusNumberStatus bonusNumberStatus) {
        return Arrays.stream(values())
                .filter(lottoStatus -> lottoStatus.isMatched(hitCount))
                .filter(lottoStatus -> lottoStatus.isMatched(BonusNumberStatus.NOT_APPLY)
                        || lottoStatus.isMatched(bonusNumberStatus))
                .findFirst()
                .orElse(LottoStatus.NOTHING);
    }

    private boolean isMatched(int hitCount) {
        return Objects.equals(this.hitCount, hitCount);
    }

    public boolean isMatched(BonusNumberStatus bonusNumberStatus) {
        return Objects.equals(this.bonusNumberStatus, bonusNumberStatus);
    }

    public int getHitCount() {
        return hitCount;
    }


    public Money getWinningAmount() {
        return winningAmount;
    }
}
