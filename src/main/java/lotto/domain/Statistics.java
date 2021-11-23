package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Statistics {

    private final Lotto won;
    private final List<Lotto> lottos;

    public Statistics(Lotto won, List<Lotto> lottos) {
        this.won = won;
        this.lottos = createResult(won, lottos);
    }

    public List<Lotto> createResult(Lotto won, List<Lotto> lottos) {
        return lottos.stream()
            .map(l -> l.createWithWon(won))
            .collect(Collectors.toList());
    }

    public Lotto getWon() {
        return won;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
