package lotto.domain;

import lotto.utils.GenerateLotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private List<Integer> number;

    public Lotto() {
        this.number = GenerateLotto.create();
    }

    public Lotto(final String number) {
        this.number = GenerateLotto.create(number);
    }

    public List<Integer> getNumber() {
        return number;
    }

    public boolean isMatchNumber(final List<Integer> numbers, final int point) {
        return calculatorLottoNumberMatchScore(numbers) == point;
    }

    private int calculatorLottoNumberMatchScore(final List<Integer> numbers) {
        int matchScore = 0;
        for (Integer num : numbers) {
            matchScore = numberMatchCheckLoop(matchScore, num);
        }
        return matchScore;
    }

    private int numberMatchCheckLoop(int matchScore, final Integer numbers) {
        for (Integer num : this.number) {
            matchScore = eqCheckLottoNumber(matchScore, numbers, num);
        }
        return matchScore;
    }

    private int eqCheckLottoNumber(int matchScore, final Integer sourceNumber, final Integer targetNumber) {
        if (sourceNumber.equals(targetNumber)) {
            matchScore = increaseMatchScore(matchScore);
        }
        return matchScore;
    }

    private int increaseMatchScore(int matchScore) {
        matchScore++;
        return matchScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(number, lotto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
