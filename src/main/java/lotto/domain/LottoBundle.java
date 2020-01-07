package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBundle {

    private List<Lotto> lottos;

    private LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    static LottoBundle of(List<Lotto> lottos) {
        return new LottoBundle(lottos);
    }

    int getLottosCount() {
        return lottos.size();
    }

    public List<String> collectNumbersAsString() {
        return lottos.stream()
                .map(Lotto::getNumbersAsString)
                .collect(Collectors.toList());
    }

    Stream<Lotto> stream() {
        return this.lottos.stream();
    }
}
