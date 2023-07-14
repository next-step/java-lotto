package lotto.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<List<Integer>> lottos) {
        return new Lottos(lottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResults matchWinningLotto(WinningLotto winningLotto) {
        return new LottoResults(
                lottos.stream()
                        .map(winningLotto::match)
                        .collect(Collectors.toList())
        );
    }

    public int size() {
        return lottos.size();
    }

    public Lottos combine(Lottos other) {
        return new Lottos(Stream.of(this.lottos, other.lottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }
}
