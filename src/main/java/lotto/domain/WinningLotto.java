package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(final List<LottoNumber> winningNumbers, final LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public Ranking matchLotto(final Lotto lotto) {
        final LottoCalculator calculator = LottoCalculator.getInstance();
        return calculator.calculate(winningNumbers, lotto.getLottoNumbers(), bonusBall);
    }
}
