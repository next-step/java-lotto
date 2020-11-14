package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(int lottoNum, NumberSelectionStrategy numberSelectionStrategy) {
        lottos = IntStream.range(0, lottoNum)
                .mapToObj(idx -> new Lotto(numberSelectionStrategy))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
