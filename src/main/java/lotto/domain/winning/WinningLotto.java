package lotto.domain.winning;

import lotto.domain.lottocreator.Lotto;
import lotto.domain.lottocreator.LottoFactory;
import lotto.domain.LottoNo;
import lotto.domain.Lottos;

import java.util.List;

public class WinningLotto {

    private Lotto winningLotto;
    private LottoNo bonusNo;

    public WinningLotto(String winningNumbers, int bonusNo) {
        this.winningLotto = LottoFactory.createWinningLotto(winningNumbers);
        this.bonusNo = LottoNo.of(bonusNo);
        validate(this.winningLotto, this.bonusNo);
    }

    private void validate(Lotto winningLotto, LottoNo bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼이 로또 당첨 번호와 중복됩니다.");
        }
    }

    public List<WinningCount> checkWinningNumbers(Lottos lottos) {
        return lottos.matchesLottos(winningLotto, bonusNo);
    }
}
