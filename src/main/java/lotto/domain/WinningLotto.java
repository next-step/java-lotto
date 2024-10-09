package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> winningNumbers;

    public WinningLotto(final List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

}
