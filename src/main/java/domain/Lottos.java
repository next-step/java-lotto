package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(LottoNumbersList lottoNumbersList) {
        this.lottos = lottoNumbersList.toList()
                .stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> toList() {
        return Collections.unmodifiableList(lottos);
    }

    public Cash totalPrice() {
        return Lotto.PRICE.multiply(size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return lottos.equals(lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
