package lotto.domain;

import lotto.utils.GenerateLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private final GenerateLotto generateLotto;
    private List<Integer> number;

    public Lotto(final GenerateLotto generateLotto) {
        this.generateLotto = generateLotto;
        this.number = createLotto();
    }

    public Lotto(final GenerateLotto generateLotto, final String number) {
        this.generateLotto = generateLotto;
        this.number = createLotto(number);
    }

    public List<Integer> getNumber() {
        return number;
    }

    public boolean isMatchNumber(final List<Integer> numbers, final int point) {
        return calculatorLottoNumberMatchScore(numbers) == point;
    }

    private List<Integer> createLotto() {
        return this.generateLotto.create();
    }

    private List<Integer> createLotto(final String number) {
        return toList(split(number));
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

    private String[] split(final String lottoNumbers) {
        return lottoNumbers.split(",");
    }

    private List<Integer> toList(final String[] lottoNumbers) {
        final List<Integer> ints = new ArrayList<>();
        for (Integer num : toInts(lottoNumbers)) {
            ints.add(num);
        }
        return ints;
    }

    private int[] toInts(final String[] lottoNumber) {
        final int[] ints = new int[lottoNumber.length];
        for (int i = 0; i < lottoNumber.length; i++) {
            ints[i] = convertInt(lottoNumber[i]);
        }
        return ints;
    }

    private int convertInt(final String text) {
        return Integer.parseInt(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(generateLotto, lotto.generateLotto) &&
                Objects.equals(number, lotto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generateLotto, number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
