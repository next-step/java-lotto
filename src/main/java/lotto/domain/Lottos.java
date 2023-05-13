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
        Lotto winningLotto = new Lotto(winningNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        if (winningLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(
                "There exists duplicate between winningNumber and bonusNumber");
        }

        return new LottoRanks(lottos.stream()
            .map(lotto -> LottoRank.valueOf(lotto.scoreHit(winningLotto),
                lotto.contains(bonusLottoNumber)))
            .collect(Collectors.toList()));
    }

    public Integer size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
