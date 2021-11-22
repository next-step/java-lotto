package lotto.vo;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos create(List<Lotto> lottoList) {
        return new Lottos(new ArrayList<>(lottoList));
    }

    public int count() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public Lottos addLottos(Lottos lottos) {
        this.lottoList.addAll(lottos.lottoList);
        return create(this.lottoList);
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
        return Objects.equals(lottoList, lottos1.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
