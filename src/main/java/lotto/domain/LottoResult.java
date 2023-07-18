package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.vo.Money;
import lotto.domain.vo.Profit;
import lotto.domain.vo.Quantity;

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
            .mapToLong(key -> key.calculatePrize(result.get(key)))
            .sum();
        return new Money(totalPrize);
    }

    private Money calculateSpentMoney() {
        long totalQuantity = result.values()
            .stream()
            .mapToLong(Long::longValue)
            .sum();
        return LottoGroup.getSpentMoney(new Quantity(totalQuantity));
    }
}
