package step2.domain;

import java.util.List;
import java.util.stream.Collectors;


public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<MatchResult> matchAll(Winning winning) {
        return lottos.stream()
                .map(winning::match)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
