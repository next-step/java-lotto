package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private List<Lotto> lottos;

    public LottoList() {
        this.lottos = new ArrayList<>();
    }

    public LottoList(final int lottosCount) {
        if (lottosCount < 1) {
            throw new IllegalArgumentException("1 OR MORE");
        }

        this.lottos = new ArrayList<>(lottosCount);

        for (int i = 0; i < lottosCount; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    boolean add(Lotto lotto) {
        return this.lottos.add(lotto);
    }

    int find(Prize prize, Lotto winningLotto) {
        LottoList winningLottos = new LottoList();

        for (Lotto lotto : this.lottos) {
            int containsCount = lotto.getContainsCount(winningLotto);

            if (containsCount == prize.getMatchingCount()) {
                winningLottos.add(lotto);
            }
        }

        return winningLottos.size();
    }
}
