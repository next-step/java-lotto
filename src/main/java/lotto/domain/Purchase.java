package lotto.domain;

import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Purchase {

    private List<Lotto> lottos;

    public Purchase(List<Lotto> manual ,List<Lotto> auto) {
        this.lottos = Stream.concat(manual.stream(), auto.stream())
                .collect(Collectors.toList());
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int lottosSize() {
        return lottos.size();
    }
}
