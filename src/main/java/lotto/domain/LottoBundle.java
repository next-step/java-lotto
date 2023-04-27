package lotto.domain;

import lotto.domain.strategy.AutomaticStrategy;

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
}
