package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        if (!isLottoNumbersSize(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto lottoNumbers size must be " + LOTTO_NUMBERS_SIZE);
        }

        if (isNumberDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto lottoNumbers must be unique");
        }

        this.lottoNumbers = convertToLottoNumbers(lottoNumbers);
    }

    private boolean isLottoNumbersSize(List<Integer> numbers) {
        return LOTTO_NUMBERS_SIZE == numbers.size();
    }

    private boolean isNumberDuplicated(List<Integer> numbers) {
        long uniqueNumbersSize = numbers.stream()
                .distinct()
                .count();

        return uniqueNumbersSize < LOTTO_NUMBERS_SIZE;
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }

    int getNumberOfDuplicatedNumbers(Lotto target) {
        int numberOfDuplicatedNumbers = 0;

        for (LottoNumber targetNumber : target.lottoNumbers) {
            numberOfDuplicatedNumbers += (containsLottoNumber(targetNumber) ? 1 : 0);
        }

        return numberOfDuplicatedNumbers;
    }

    boolean containsLottoNumber(LottoNumber target) {
        return this.lottoNumbers.contains(target);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
