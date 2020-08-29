package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int count, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottos.add(Lotto.of(lottoNumberGenerator));
        }
        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
