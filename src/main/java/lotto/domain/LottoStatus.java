package lotto.domain;

import lotto.generic.Money;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoStatus {
    NOTHING(0, 0L),
    FOURTH(3, 5000L),
    THIRD(4, 50000L),
    SECOND(5, 1500000L),
    FIRST(6, 2000000000L);

    private static final Map<Integer, LottoStatus> lottoStatusMap =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(LottoStatus::getHitCount, Function.identity())));

    private final int hitCount;

    private final Money winningAmount;

    LottoStatus(final int hitCount, final long winningAmount) {
        this.hitCount = hitCount;
        this.winningAmount = Money.wons(winningAmount);
    }

    public static LottoStatus find(final int hitCount) {
        return Optional.ofNullable(lottoStatusMap.get(hitCount))
                .orElse(LottoStatus.NOTHING);
    }

    public int getHitCount() {
        return hitCount;
    }

    public Money getWinningAmount() {
        return winningAmount;
    }

    @Override
    public String toString() {
        return hitCount + "개 일치 (" + winningAmount + ")";
    }
}
