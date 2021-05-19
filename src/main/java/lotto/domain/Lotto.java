package lotto.domain;

import java.util.Set;

public class Lotto {
    public static final int MININUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final long PRICE = 1_000L;

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
