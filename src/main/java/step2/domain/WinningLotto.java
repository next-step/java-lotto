package step2.domain;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private Lotto lotto;

    public WinningLotto(List<Integer> lottoNumber) {
        this.lotto = new Lotto(lottoNumber);
    }

    public Set<LottoNumber> getWinningNumber() {
        return this.lotto.getNumbers();
    }
}
