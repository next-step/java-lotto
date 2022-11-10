package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    FIRST(LottoNumberMatchCount.ALL, false, Money.wons(2_000_000_000)),

    SECOND(LottoNumberMatchCount.FIVE, true, Money.wons(30_000_000)),

    THIRD(LottoNumberMatchCount.FIVE, false, Money.wons(1_500_000)),

    FOURTH(LottoNumberMatchCount.FOUR, false, Money.wons(50_000)),

    FIFTH(LottoNumberMatchCount.THREE, false, Money.wons(5_000)),

    NOTHING(LottoNumberMatchCount.NOTHING, false, Money.ZERO);

    private final LottoNumberMatchCount lottoNumberMatchCount;
    private final boolean matchBonusBall;
    private final Money prizeMoney;

    LottoResult(
        final LottoNumberMatchCount lottoNumberMatchCount,
        final boolean matchBonusBall,
        final Money prizeMoney
    ) {
        this.lottoNumberMatchCount = lottoNumberMatchCount;
        this.matchBonusBall = matchBonusBall;
        this.prizeMoney = prizeMoney;
    }

    public static LottoResult valueOf(
        final LottoNumberMatchCount lottoNumberMatchCount,
        final boolean matchBonusBall
    ) {
        return Arrays.stream(values())
            .filter(result ->
                result.isSameLottoNumberMatchCount(lottoNumberMatchCount)
                    && result.isMatchedBonusBall(matchBonusBall))
            .findFirst()
            .orElse(LottoResult.NOTHING);
    }

    public boolean isSameLottoNumberMatchCount(final LottoNumberMatchCount other) {
        return this.lottoNumberMatchCount.equals(other);
    }

    public boolean isMatchedBonusBall(final boolean matchBonusBall) {
        if (canSkipBonusBallMatchResult()) {
            return true;
        }
        return this.matchBonusBall == matchBonusBall;
    }

    private boolean canSkipBonusBallMatchResult() {
        // 정의된 로또등수의 보너스볼 포함여부가 false일경우, 보너스 볼 일치 여부는 판단하지 않는다
        if (this.matchBonusBall == false) {
            return true;
        }
        return false;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public LottoNumberMatchCount getLottoNumberMatchCount() {
        return lottoNumberMatchCount;
    }

}
