package lotto.domain;

import java.util.Collection;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private final int bonusNumber;

    public Lotto(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto(Collection<Integer> numbers, int bonusNumber) {
        this(new LottoNumbers(numbers), bonusNumber);
    }

    public static Lotto of(Collection<Integer> numbers, int bonusNumber) {
        return new Lotto(numbers, bonusNumber);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getMatchCount(Lotto lotto) {
        return lottoNumbers.getMatchCount(lotto.getLottoNumbers());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
