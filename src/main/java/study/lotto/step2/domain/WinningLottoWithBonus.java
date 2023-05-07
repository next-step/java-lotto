package study.lotto.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoWithBonus {
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLottoWithBonus(WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResults resultsOf(Lottos lottos) {
        return new LottoResults(resultsOf(lottos.getLottos()));
    }

    public LottoResult resultOf(Lotto lotto) {
        return LottoResult.of(winningLotto.numbersOfMatch(lotto), bonusNumber.matchBonus(lotto));
    }

    private List<LottoResult> resultsOf(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::resultOf)
                .collect(Collectors.toUnmodifiableList());
    }
}