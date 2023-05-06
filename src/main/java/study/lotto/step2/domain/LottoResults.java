package study.lotto.step2.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResults {
    private static final long LOTTO_PRICE = 1_000L;
    private static final int DIVIDE_SCALE = 2;
    private static final RoundingMode DIVIDE_ROUNDING_MODE = RoundingMode.FLOOR;
    private final List<LottoResult> lottoResults;

    public LottoResults(LottoResult...lottoResults) {
        this(of(lottoResults));
    }

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public long winningAmount() {
        return lottoResults.stream()
                .mapToLong(LottoResult::payout)
                .sum();
    }

    public String rateOfReturn() {
        return new BigDecimal(winningAmount())
                .divide(purchaseAmount(), DIVIDE_SCALE, DIVIDE_ROUNDING_MODE)
                .stripTrailingZeros()
                .toPlainString();
    }

    public int countOf(LottoResult findLottoResult) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(findLottoResult))
                .mapToInt(lottoResult -> 1)
                .sum();
    }

    private BigDecimal purchaseAmount() {
        return new BigDecimal(lottoResults.size() * LOTTO_PRICE);
    }

    private static List<LottoResult> of(LottoResult...lottoResults) {
        return Arrays.stream(lottoResults)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoResults)) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
