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

    private void put(Rank rank) {
        result.merge(rank, 1, Integer::sum);
    }

    public void result(WinningLotto winningLotto, LottoTickets tickets) {
        List<Lotto> lottos = tickets.getTickets();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.matches(lotto);
            put(rank);
        }
    }

    public Map<Rank, Integer> getStatistics() {
        return this.result;
    }
}
