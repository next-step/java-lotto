package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<LottoRank, Long> result;

    public LottoResult(final Map<LottoRank, Long> result) {
        this.result = result;
    }

    public static LottoResult of(final LottoGroup lottoGroup, final WinningLotto winningLotto) {
        return new LottoResult(
                lottoGroup.getLottos()
                        .stream()
                        .collect(Collectors.groupingBy(winningLotto::calculateRank, Collectors.counting()))
        );
    }

    public Money calculateTotalPrize() {
        long totalPrize = result.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return new Money(totalPrize);
    }

    public Map<LottoRank, Long> getResult() {
        return result;
    }

    public Double calculateYield() {
        return this.calculateTotalPrize()
                .calculateYield(calculateTotalMoney());
    }

    private Money calculateTotalMoney() {
        long totalQuantity = result.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
        return new Money(totalQuantity * LottoGroup.LOTTO_PRICE);
    }

}
