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
                result.lottoNumberMatchCount.equals(lottoNumberMatchCount)
                    && result.matchBonusBall == matchBonusBall)
            .findFirst()
            .orElse(LottoResult.NOTHING);
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public LottoNumberMatchCount getLottoNumberMatchCount() {
        return lottoNumberMatchCount;
    }

}
