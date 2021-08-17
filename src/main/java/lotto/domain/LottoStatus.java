package lotto.domain;

import lotto.generic.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum LottoStatus {
    NOTHING(0, BonusNumberStatus.NOT_APPLY,0L),
    FIFTH(3, BonusNumberStatus.NOT_APPLY,5_000L),
    FOURTH(4, BonusNumberStatus.NOT_APPLY,50_000L),
    THIRD(5, BonusNumberStatus.MISS,1_500_000L),
    SECOND(5, BonusNumberStatus.MATCH,30_000_000L),
    FIRST(6, BonusNumberStatus.NOT_APPLY,2_000_000_000L);

    private final HitCount hitCount;

    private final BonusNumberStatus bonusNumberStatus;

    private final Money winningAmount;

    LottoStatus(final int hitCount, final BonusNumberStatus bonusNumberStatus, final long winningAmount) {
        this.hitCount = new HitCount(hitCount);
        this.bonusNumberStatus = bonusNumberStatus;
        this.winningAmount = Money.wons(winningAmount);
    }

    public static LottoStatus find(final HitCount hitCount, final BonusNumberStatus bonusNumberStatus) {
        List<LottoStatus> lottoStatuses = find(hitCount);
        if (lottoStatuses.size() == 1) {
            return lottoStatuses.get(0);
        }
        return lottoStatuses.stream()
                .filter(lottoStatus -> lottoStatus.isMatched(bonusNumberStatus))
                .findFirst()
                .orElse(LottoStatus.NOTHING);
    }

    private static List<LottoStatus> find(final HitCount hitCount) {
        return Arrays.stream(values())
                .filter(lottoStatus -> lottoStatus.isMatched(hitCount))
                .collect(Collectors.toList());
    }

    private boolean isMatched(final HitCount hitCount) {
        return Objects.equals(this.hitCount, hitCount);
    }

    public boolean isMatched(final BonusNumberStatus bonusNumberStatus) {
        return Objects.equals(this.bonusNumberStatus, bonusNumberStatus);
    }

    public int getHitCount() {
        return hitCount.getValue();
    }


    public Money getWinningAmount() {
        return winningAmount;
    }
}
