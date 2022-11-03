package lotto.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> list;

    public Lottos(List<Lotto> list) {
        this.list = list;
    }

    public Lottos concat(Lottos lottos) {
        return new Lottos(Stream.concat(list.stream(), lottos.list.stream())
                .collect(Collectors.toList()));
    }

    public LottoResult winPrizes(Lotto winNumbers, LottoNumber bonusNumber) {
        return new LottoResult(list.stream()
                .map(lotto -> lotto.matches(winNumbers, bonusNumber))
                .collect(Collectors.toList()));
    }

    public void forEach(Consumer<? super Lotto> consumer) {
        list.forEach(consumer);
    }

    public Positive size() {
        return new Positive(list.size());
    }
}
