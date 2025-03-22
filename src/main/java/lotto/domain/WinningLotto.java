package lotto.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto(Collection<LottoNumber> lottoNumbers) {
        this.lotto = new Lotto(lottoNumbers);
    }

    public WinningLotto(int... numbers) {
        this.lotto = new Lotto(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
