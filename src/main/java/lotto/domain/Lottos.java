package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResults matches(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> winningLotto.matchWinning(lotto))
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningResults::new));
    }

    public List<Lotto> getValues() {
        return new ArrayList<>(lottos);
    }
}
