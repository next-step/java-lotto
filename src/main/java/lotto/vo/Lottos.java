package lotto.vo;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public static Lottos create(List<Lotto> lottoList) {
        return new Lottos(new ArrayList<>(lottoList));
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
