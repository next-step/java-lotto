package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos of(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public LottoResult getResult(final WinningLotto winningLotto) {
        final LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoList) {
            lottoResult.updateCount(lotto.findRankingByLotto(winningLotto.getWinningLotto()));
        }
        return lottoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
