package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.constant.LottoRank;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoRanks drawLots(Lotto winningNumber) {
        return new LottoRanks(lottos.stream()
            .map(lotto -> lotto.scoreHit(winningNumber))
            .map(LottoRank::toWinLotto)
            .collect(Collectors.toList()));
    }

    public Integer size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
