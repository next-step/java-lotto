package step4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> collectRank(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.getRank(winningNumbers))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(lotto -> lotto.toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
