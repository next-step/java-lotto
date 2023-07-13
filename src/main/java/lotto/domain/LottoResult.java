package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoRank, Long> result;

    public LottoResult(final Map<LottoRank, Long> result) {
        this.result = result;
    }

    public static LottoResult of(final LottoGroup lottoGroup, final WinningLotto winningLotto) {
        Map<LottoRank, Long> rankMap = lottoGroup.getLottos().stream()
            .collect(Collectors.groupingBy(winningLotto::calculateRank, Collectors.counting()));
        return new LottoResult(rankMap);
    }

    public Map<LottoRank, Long> getResult() {
        return result;
    }

    public Profit calculateProfit() {
        Money totalPrize = calculateTotalPrize();
        return new Profit(totalPrize, calculateSpentMoney());
    }

    private Money calculateTotalPrize() {
        Long totalPrize = result.keySet()
            .stream()
            .mapToLong(key -> key.getPrize() * result.get(key))
            .sum();
        return new Money(totalPrize);
    }

    private Money calculateSpentMoney() {
        long totalQuantity = result.values()
            .stream()
            .mapToLong(Long::longValue)
            .sum();
        return LottoGroup.getSpentMoney(totalQuantity);
    }
}
