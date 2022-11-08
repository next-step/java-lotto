package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    FIRST(LottoNumberMatchCount.ALL, Money.wons(2_000_000_000)),

    SECOND(LottoNumberMatchCount.FIVE, Money.wons(1_500_000)),

    THIRD(LottoNumberMatchCount.FOUR, Money.wons(50_000)),

    FOURTH(LottoNumberMatchCount.THREE, Money.wons(5_000)),

    NOTHING(LottoNumberMatchCount.NOTHING, Money.ZERO);

    private final LottoNumberMatchCount lottoNumberMatchCount;
    private final Money prizeMoney;

    LottoResult(final LottoNumberMatchCount lottoNumberMatchCount, final Money prizeMoney) {
        this.lottoNumberMatchCount = lottoNumberMatchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoResult valueOf(final LottoNumberMatchCount lottoNumberMatchCount) {
        return Arrays.stream(values())
            .filter(result -> result.lottoNumberMatchCount.equals(lottoNumberMatchCount))
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
