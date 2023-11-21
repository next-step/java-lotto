package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Purchase {

    private List<Lotto> lottos;

    public Purchase(List<Lotto> manual, List<Lotto> auto) {
        this.lottos = Collections.unmodifiableList(Stream.concat(manual.stream(), auto.stream())
                .collect(Collectors.toList()));
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int lottosSize() {
        return lottos.size();
    }
}
