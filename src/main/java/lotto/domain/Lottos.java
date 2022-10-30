package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Long> getAccordanceCounts(WinningNumbers winningNumbers) {
        return lottos.stream()
            .map(lotto -> lotto.countSameNumbers(winningNumbers))
            .collect(toList());
    }

    public int getCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
