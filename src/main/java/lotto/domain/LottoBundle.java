package lotto.domain;

import lotto.domain.strategy.AutomaticStrategy;
import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;

import java.util.ArrayList;
import java.util.List;

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
}
