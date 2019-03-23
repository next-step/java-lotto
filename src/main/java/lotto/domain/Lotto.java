package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (!isLottoNumbersSize(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto lottoNumbers size must be " + LOTTO_NUMBERS_SIZE);
        }

        if (isNumberDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto lottoNumbers must be unique");
        }

        this.lottoNumbers = lottoNumbers;
    }

    private boolean isLottoNumbersSize(List<LottoNumber> numbers) {
        return LOTTO_NUMBERS_SIZE == numbers.size();
    }

    private boolean isNumberDuplicated(List<LottoNumber> numbers) {
        long uniqueNumbersSize = numbers.stream()
                .distinct()
                .count();

        return uniqueNumbersSize < LOTTO_NUMBERS_SIZE;
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
