package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    public static final long PRICE = 1000L;

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto auto() {
        return new Lotto(LottoNumbersGenerator.generate());
    }

    public Set<Integer> getNumbers() {
        return lottoNumbers.getValue();
    }

    private int countOfMatch(Lotto winningLotto) {
        return lottoNumbers.matchNumbers(winningLotto.lottoNumbers);
    }

    public WinningType match(Lotto winningLotto) {
        return WinningType.findType(this.countOfMatch(winningLotto));
    }
}
