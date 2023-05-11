package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.constant.LottoRank;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoRanks drawLots(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoRanks(lottos.stream()
            .map(lotto -> LottoRank.valueOf(lotto.scoreHit(new Lotto(winningNumbers)),
                lotto.contains(new LottoNumber(bonusNumber))))
            .collect(Collectors.toList()));
    }

    public Integer size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
