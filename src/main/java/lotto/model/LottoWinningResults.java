package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.model.wrapper.Payment.LOTTO_PRICE;

public class LottoWinningResults {
    private Map<LottoWinningResult, Long> lottoResults;

    private LottoWinningResults(final Map<LottoWinningResult, Long> result) {
        this.lottoResults = Collections.unmodifiableMap(result);
    }

    public static LottoWinningResults create(final List<LottoWinningResult> lottoWinningResults) {
        Map<LottoWinningResult, Long> result = lottoWinningResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new LottoWinningResults(result);
    }

    public long count(final LottoWinningResult lottoWinningResult) {
        return lottoResults.getOrDefault(lottoWinningResult, 0L);
    }

    public BigDecimal profit() {
        BigDecimal totalPrice = BigDecimal.valueOf(getTotalPrice());
        BigDecimal purchasePayment = BigDecimal.valueOf(getPurchasePayment());
        return totalPrice.divide(purchasePayment, 1, RoundingMode.HALF_UP);
    }

    private long getTotalPrice() {
        return lottoResults.keySet()
                .stream()
                .mapToLong(result -> result.getPrice() * lottoResults.get(result))
                .sum();
    }

    private long getPurchasePayment() {
        return lottoResults.keySet()
                .stream()
                .mapToLong(result -> lottoResults.getOrDefault(result, 0L))
                .sum() * LOTTO_PRICE;
    }

    public Map<LottoWinningResult, Long> getLottoResults() {
        return lottoResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoWinningResults)) return false;
        LottoWinningResults that = (LottoWinningResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
