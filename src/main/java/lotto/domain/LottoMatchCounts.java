package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMatchCounts {
    private final List<LottoMatchCount> values = new ArrayList<>();

    public LottoMatchCounts(List<LottoMatchCount> values) {
        if (values != null && !values.isEmpty()) {
            this.values.addAll(values);
        }
    }

    public List<Rank> ranks() {
        return values.stream()
                .map(matchCount -> Rank.valueOf(matchCount.value()))
                .collect(Collectors.toList());
    }
}
