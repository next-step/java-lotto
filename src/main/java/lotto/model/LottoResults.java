package lotto.model;

import static lotto.model.Payment.ZERO;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResults {

    private Map<LottoResult, Long> lottoResults;

    private LottoResults(Map<LottoResult, Long> result) {
        this.lottoResults = Collections.unmodifiableMap(result);
    }

    public static LottoResults of(List<LottoResult> lottoResults) {
        Map<LottoResult, Long> result = lottoResults.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new LottoResults(result);
    }

    public Long count(LottoResult lottoResult) {
        return lottoResults.getOrDefault(lottoResult, 0L);
    }

    public Map<LottoResult, Long> getResult() {
        Map<LottoResult, Long> result = getDefaultResult();
        result.putAll(this.lottoResults);
        return result;
    }

    private static Map<LottoResult, Long> getDefaultResult() {
        Map<LottoResult, Long> defaultResult = new LinkedHashMap<>();
        Arrays.stream(LottoResult.values())
            .forEach(lottoResult -> defaultResult.put(lottoResult, 0L));
        return defaultResult;
    }

    public Double getProfit() {
        return getTotalPrice() / getPurchasePayment();
    }

    private Long getTotalPrice() {
        return lottoResults.keySet()
            .stream()
            .mapToLong(result -> result.getPrice() * lottoResults.get(result))
            .sum();
    }

    private double getPurchasePayment() {
        double totalPrice = (double) lottoResults.keySet()
            .stream()
            .mapToLong(result -> lottoResults.getOrDefault(result, 0L))
            .sum();

        validatePurchasePayment(totalPrice * Payment.LOTTO_PRICE);

        return totalPrice * Payment.LOTTO_PRICE;
    }

    private void validatePurchasePayment(double purchasePayment) {
        if (purchasePayment <= ZERO) {
           throw new IllegalArgumentException("구매 금액은 0원입니다. 구매 금액을 확인해 주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoResults)) {
            return false;
        }
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
