package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos merge(Lottos manual, Lottos auto) {
        List<Lotto> combined = Stream.concat(manual.stream(), auto.stream())
                .collect(Collectors.toList());
        return new Lottos(combined);
    }

    public int size() {
        return lottos.size();
    }

    public List<MatchResult> matchAll(Winning winning) {
        return lottos.stream()
                .map(winning::match)
                .collect(Collectors.toList());
    }
    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
