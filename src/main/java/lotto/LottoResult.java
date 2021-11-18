package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Prize, Integer> result;

    private static final int ZERO = 0;
    private static final int DEFAULT_INCREMENT = 1;

    public LottoResult(List<Lotto> lottos, Lotto target) {
        this.result = getResult(lottos, target);
    }

    private Map<Prize, Integer> getResult(List<Lotto> lottos, Lotto target) {
        Map<Prize, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            Prize prize = Prize.of(lotto.result(target));

            result.put(prize, incrementValue(result, prize));
        }

        return result;
    }

    private int incrementValue(Map<Prize, Integer> result, Prize prize) {
        if (result.containsKey(prize)){
            return result.get(prize) + DEFAULT_INCREMENT;
        }

        return DEFAULT_INCREMENT;
    }

    public int result(Prize prize) {
        if (this.result.containsKey(prize)) {
            return this.result.get(prize);
        }

        return ZERO;
    }

    public double totalPrize() {
        return this.result.keySet().stream()
                .mapToDouble(prize -> prize.money() * this.result.get(prize))
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
