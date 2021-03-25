package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.of();
            list.add(lotto);
        }
        return new Lottos(list);
    }
    public Hit getWinnerStatistics(WinningNumber winningNumber) {
        Hit hit = new Hit();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumber);
            hit.hittingLottoStatistics(matchCount);
        }
        return hit;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
