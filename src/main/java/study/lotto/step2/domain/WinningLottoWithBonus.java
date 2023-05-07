package study.lotto.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoWithBonus {
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLottoWithBonus(WinningLotto winningLotto, BonusNumber bonusNumber) {
        validateBonusLottoNumber(winningLotto, bonusNumber);
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

    private void validateBonusLottoNumber(WinningLotto winningLotto, BonusNumber bonusNumber) {
        if(winningLotto.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함되어 있으면 안됩니다: " + bonusNumber);
        }
    }
}