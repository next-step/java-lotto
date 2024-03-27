package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoRank, Integer> result;

    public LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public LottoResult(LottoRank... rank) {
        this(Arrays.stream(rank)
            .collect(
                Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1))
            ));
    }

    public double calculateReturnRate(int payed) {
        Money totalPrize = Money.zero();
        for (LottoRank rank : result.keySet()) {
            totalPrize.sum(rank.getPrize() * result.get(rank));
        }
        return totalPrize.calculateReturnRate(payed);
    }

    public int countRank(LottoRank rank) {
        return result.getOrDefault(rank, 0);
    }


    @Override
    public String toString() {
        return "LottoResult{" +
            "result=" + result +
            '}';
    }
}
