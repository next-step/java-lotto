package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningCondition {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningCondition(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validate(winningLotto, bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        if (winningLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 번호를 입력할 수 없습니다.");
        }
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
