package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Lotto winningLotto;

    private LottoNumber bonusBall;

    public WinningLotto(String winningNumbers, int bonusBall) {
        this.winningLotto = LottoFactory.createManualLotto(winningNumbers);
        this.bonusBall = LottoNumber.of(bonusBall);
        validate(this.winningLotto, this.bonusBall);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼이 로또 당첨 번호와 중복됩니다.");
        }
    }

    public List<Integer> checkWinningNumbers(Lottos lottos) {
        return lottos.matchesLottos(winningLotto);
    }
}
