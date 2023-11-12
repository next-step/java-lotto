package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private final Lottos lottos;

    public LottoMachine(Lottos lottos,
                        Lottos manaulLottos) {
        this.lottos = new Lottos(lottos, manaulLottos);
    }

    public Lottos getLottoNumbers() {
        return this.lottos;
    }

    public WinningResults report(WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = winningLotto.winningRank(lottos);
        return new WinningResults(lottoRanks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMachine that = (LottoMachine) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
