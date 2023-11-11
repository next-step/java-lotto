package step2.domain;

import step2.domain.type.Prize;
import step2.exception.InvalidLottoNumberCountException;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_MAX_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() > LOTTO_MAX_SIZE) {
            throw new InvalidLottoNumberCountException();
        }
    }

    public Prize prize(Lotto prizeLotto) {
        return Prize.of(countOfWinningNumber(prizeLotto));
    }

    private int countOfWinningNumber(Lotto prizeLotto) {
        return StatisticsCalculator.numberOfMatches(this.numbers, prizeLotto.numbers());
    }

    public List<Integer> numbers() {
        return this.numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
