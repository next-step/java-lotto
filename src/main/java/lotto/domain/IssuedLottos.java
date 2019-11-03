package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IssuedLottos {

    private final List<Lotto> lottos;
    private int[] winCount;

    public IssuedLottos(final List<Lotto> lottos) {
        this.lottos = lottos;
        int matchedNumberCountSize = 0;
        if (lottos != null && !lottos.isEmpty()) {
            Lotto lotto = lottos.get(0);
            matchedNumberCountSize = lotto.countNumber() + 1;
        }
        this.winCount = new int[matchedNumberCountSize];
    }

    public int count() {
        return this.lottos.size();
    }

    public void checkNumbers(final List<Integer> winNumbers) {
        for (Lotto lotto : lottos) {
            final int matchedNumberCount = lotto.findMatchedNumberCount(winNumbers);
            winCount[matchedNumberCount]++;
        }
    }

    public int countWin(final int matchedNumberCount) {
        return this.winCount[matchedNumberCount];
    }

    public List<Lotto> findAllIssuedLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuedLottos that = (IssuedLottos) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
