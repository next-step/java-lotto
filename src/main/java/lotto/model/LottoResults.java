package lotto.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

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

    public Long count(final LottoResult lottoResult) {
        return lottoResults.getOrDefault(lottoResult, 0L);
    }

    public Map<LottoResult, Long> getResult() {
        Map<LottoResult, Long> result = getDefaultResult();
        result.putAll(this.lottoResults);
        return result;
    }

    public Double profit() {
        return getTotalPrice() / getPurchasePayment();
    }

    private static Map<LottoResult, Long> getDefaultResult() {
        Map<LottoResult, Long> defaultResult = new LinkedHashMap<>();
        Arrays.stream(LottoResult.values())
                .forEach(lottoResult -> defaultResult.put(lottoResult, 0L));
        return defaultResult;
    }

    private Long getTotalPrice() {
        return lottoResults.keySet()
                .stream()
                .mapToLong(result -> result.getPrice() * lottoResults.get(result))
                .sum();
    }

    private double getPurchasePayment() {
        return (double) lottoResults.keySet()
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
