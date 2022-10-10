package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningCondition {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningCondition(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public List<LottoRank> getRanks(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::getRank)
                .collect(Collectors.toList());
    }

    public LottoRank getRank(Lotto lotto) {
        return LottoRank.of(winningLotto.countMatchNumbers(lotto), lotto.contains(bonusLottoNumber));
    }

}
