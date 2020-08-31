package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public Map<Integer, Long> getRanksCount() {
        return ranks.stream()
                .collect(Collectors.groupingBy(Rank::getOrdinal,
                        Collectors.counting()));
    }
}
