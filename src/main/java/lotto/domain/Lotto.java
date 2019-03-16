package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    int getNumberOfDuplicatedNumbers(Lotto target) {
        int numberOfDuplicatedNumbers = 0;

        for (int targetNumber : target.lottoNumbers) {
            numberOfDuplicatedNumbers += getNumberOfDuplicatedNumber(this.lottoNumbers, targetNumber);
        }

        return numberOfDuplicatedNumbers;
    }

    private int getNumberOfDuplicatedNumber(List<Integer> numbers, int target) {
        return (numbers.contains(target) ? 1 : 0);
    }
}