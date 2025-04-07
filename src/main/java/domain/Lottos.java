package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> value;

    public Lottos(List<Lotto> value) {
        this.value = value;
    }

    public List<Lotto> getValue() {
        return value;
    }

    public List<Rank> match(WinningNumber winningNumber) {
        return value.stream()
                .map(lotto -> RankDecider.decide(lotto, winningNumber))
                .collect(Collectors.toList());
    }
}
