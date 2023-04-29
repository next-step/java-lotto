package lotto.domain;

import lotto.domain.strategy.AutomaticStrategy;
import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoBundle {
    private final Lottos automaticLottos;
    private final Lottos manualLottos;

    public LottoBundle(List<String> manualNumbers, int autoCount) {
        this.automaticLottos = new Lottos(autoCount, new AutomaticStrategy());
        this.manualLottos = Lottos.manualLottos(manualNumbers);
    }

    public List<List<Integer>> getLottoNumbers() {
        final List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(manualLottos.lottoNumberList());
        lottoNumbers.addAll(automaticLottos.lottoNumberList());

        return lottoNumbers;
    }

    public WinningStat rating(WinningBall winningBall) {
        final WinningStat winningStat = new WinningStat();

        this.automaticLottos.rating(winningStat, winningBall);
        this.manualLottos.rating(winningStat, winningBall);

        return winningStat;
    }

    public int getManualCount() {
        return this.manualLottos.size();
    }

    public int getAutoCount() {
        return this.automaticLottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBundle that = (LottoBundle) o;
        return Objects.equals(automaticLottos, that.automaticLottos) && Objects.equals(manualLottos, that.manualLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(automaticLottos, manualLottos);
    }
}
