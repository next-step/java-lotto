package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int TOTAL_LOTTO_NUMBERS = 6;
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        checkLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumbers(List<Integer> lottoNumbers) {
        if (!isLottoNumbersSizeCorrect(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto numbers size must be " + TOTAL_LOTTO_NUMBERS);
        }

        if (!isLottoNumbersUnique(lottoNumbers)) {
            throw new IllegalArgumentException("Every lotto numbers must be unique");
        }

        if (!isLottoNumbersCorrect(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }
    }

    private boolean isLottoNumbersUnique(List<Integer> lottoNumbers) {
        long numberOfUniqueNumbers = lottoNumbers.stream().distinct().count();
        return lottoNumbers.size() == numberOfUniqueNumbers;
    }

    private boolean isLottoNumbersSizeCorrect(List<Integer> lottoNumbers) {
        return TOTAL_LOTTO_NUMBERS == lottoNumbers.size();
    }

    private boolean isLottoNumbersCorrect(List<Integer> lottoNumbers) {
        long correctLottoNumbers = lottoNumbers.stream()
                .filter(this::isLottoNumberCorrect)
                .count();

        return correctLottoNumbers == lottoNumbers.size();
    }

    private boolean isLottoNumberCorrect(int lottoNumber) {
        return (MIN_NUMBER <= lottoNumber) && (lottoNumber <= MAX_NUMBER);
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

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}