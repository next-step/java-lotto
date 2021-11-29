package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Prize, Integer> value;

    /*
        CONSTRUCTOR
     */
    public LottoResult(Map<Prize, Integer> value) {
        this.value = value;
    }

    public LottoResult(List<Lotto> lottos, WinLotto winLotto) {
        final Map<Prize, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            final Prize prize = winLotto.match(lotto);
            result.putIfAbsent(prize, 0);
            result.put(prize, result.get(prize) + 1);
        }

        this.value = result;
    }

    /*
        INTERFACE
     */
    public int countByPrize(Prize prize) {
        return this.value.getOrDefault(prize, 0);
    }

    public double rate(Money unitPrice) {
        long lottoCount = value.values()
                .stream()
                .mapToInt(count -> count)
                .sum();

        final double totalPrize = value.keySet()
                .stream()
                .mapToDouble(prize -> prize.getPrize() * this.value.get(prize))
                .sum();

        return totalPrize / unitPrice.multiply(lottoCount);
    }

    /*
        FUNCTION
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
