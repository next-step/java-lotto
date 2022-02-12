package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(final int count, final Lotto lotto){
        this.lottos = IntStream.range(0, count)
            .mapToObj(idx -> lotto)
            .collect(Collectors.toList());
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
