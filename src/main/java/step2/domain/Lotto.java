package step2.domain;

import java.util.List;
import java.util.Objects;

import static step2.domain.StatisticsCalculator.isContain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countOfWinningNumber(PrizeLotto prizeLotto) {
        return StatisticsCalculator.numberOfMatches(numbers(), prizeLotto.numbers());
    }

    public boolean isBonusMatched(PrizeLotto prizeLotto) {
        return isContain(numbers(), prizeLotto.bonusNumber());
    }

    public List<Integer> numbers() {
        return this.lottoNumbers.numbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
