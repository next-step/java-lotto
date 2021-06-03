package lotto;

import java.util.List;

public class WinningLotto {
    private List<LottoNumber> winningLotto;

    public WinningLotto(List<LottoNumber> winningNumbers) {
        this.winningLotto = winningNumbers;
    }

    public List<LottoNumber> value() {
        return winningLotto;
    }
}
