package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<Rank, Integer> result;

    public LottoResult() {
        this.result = Arrays.stream(Rank.values())
            .collect(Collectors.toMap(Function.identity(), value -> 0, (x, y) -> y, LinkedHashMap::new));
    }

    public void put(Rank rank) {
        result.merge(rank, 1, Integer::sum);
    }

    public void result(Lotto winningNumbers, List<Lotto> lottoNumbers, int bonusBall) {
        for (Lotto lotto : lottoNumbers) {
            int count = lotto.matches(winningNumbers);
            Rank calculate = Rank.calculate(count, lotto.matches(bonusBall));
            put(calculate);
        }
    }

    public Map<Rank, Integer> getStatistics() {
        return this.result;
    }
}
