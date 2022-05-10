package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prize {
    private final Map<Rank, Number> ranks;

    private Prize() {
        this.ranks = new HashMap<>();
    }

    public static Prize work(Lotto beforeLotto, List<Lotto> lottoList) {
        return new Prize()
                .classify(beforeLotto, lottoList);
    }

    private Prize classify(Lotto beforeLotto, List<Lotto> lottoList) {
        lottoList.forEach(lotto -> {
            Number correctCount = Lotto.match(beforeLotto, lotto);
            Rank rank = Rank.valueOf(correctCount);

            this.ranks.computeIfAbsent(rank, r -> Number.of());
            this.ranks.computeIfPresent(rank, (r, count) -> count.incrementAndGet());
        });

        return this;
    }

    public Map<Rank, Number> getRanks() {
        return this.ranks;
    }
}
