package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<Rank, Long> result;

    public LottoResult(final List<Rank> ranks) {
        this.result = ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public float calculateRateOfReturn(final Money money) {
        float sumResult = 0;
        for (Map.Entry<Rank, Long> entry : this.result.entrySet()) {
            sumResult += entry.getKey().totalMoney(entry.getValue());
        }
        return money.rateOfReturn(sumResult);
    }

    public Map<Rank, Long> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
