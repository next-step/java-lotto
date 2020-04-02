package lotto.model;

import lotto.model.dto.LottoWinResults;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.model.wrapper.Payment.LOTTO_PRICE;

public class LottoResults {
    private Map<LottoResult, Long> lottoResults;

    private LottoResults(final Map<LottoResult, Long> result) {
        this.lottoResults = Collections.unmodifiableMap(result);
    }

    public static LottoResults create(final List<LottoResult> lottoResults) {
        Map<LottoResult, Long> result = lottoResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new LottoResults(result);
    }

    public long count(final LottoResult lottoResult) {
        return lottoResults.getOrDefault(lottoResult, 0L);
    }

    public LottoWinResults getWinResult() {
        Map<LottoResult, Long> result = new LinkedHashMap<>();
        Arrays.stream(LottoResult.values())
                .forEach(lottoResult -> result.put(lottoResult, 0L));

        result.putAll(this.lottoResults);
        return LottoWinResults.newInstance(result);
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
