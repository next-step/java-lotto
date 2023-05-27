package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final int purchaseCount;

    public Lottos(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(Lotto.createLottoNumber());
        }
        return lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return purchaseCount == lottos.purchaseCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseCount);
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "purchaseCount=" + purchaseCount +
                '}';
    }
}
