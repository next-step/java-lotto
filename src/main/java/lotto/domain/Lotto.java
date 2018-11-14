package lotto.domain;

import lotto.utils.GenerateLotto;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

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

    public boolean lottoOfRank(final Lotto lotto, final Rank rank) {
        return calculatorLottoNumberMatchScore(lotto) == rank.getCountOfMatch();
    }

    public boolean eqBonus(final int bonus) {
        return getNumber().stream().filter(number -> number == bonus).collect(toList()).size() > 0;
    }

    private int calculatorLottoNumberMatchScore(final Lotto lotto) {
        int matchScore = 0;
        for (Integer num : lotto.getNumber()) {
            matchScore = numberMatchCheckLoop(matchScore, num);
        }
        return matchScore;
    }

    private int numberMatchCheckLoop(int matchScore, final Integer numbers) {
        for (Integer num : getNumber()) {
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
