package step2.domain;

import step2.domain.type.Prize;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Prize prize(PrizeLotto prizeLotto) {
        return Prize.of(countOfWinningNumber(prizeLotto));
    }

    private int countOfWinningNumber(PrizeLotto prizeLotto) {
        return StatisticsCalculator.numberOfMatches(numbers(), prizeLotto.numbers());
    }

    public List<Integer> numbers() {
        return this.lottoNumber.numbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

}
