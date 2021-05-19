package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult matches(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningResult::new));
    }

    public List<Lotto> getValues() {
        return new ArrayList<>(lottos);
    }
}
