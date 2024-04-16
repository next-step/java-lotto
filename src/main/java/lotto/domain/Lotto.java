package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.*;

public class Lotto {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.lottoNumbers = numbers;
    }

    public String getLottoNumbers() {
        return Arrays.toString(lottoNumbers.toArray());
    }

    public static void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR.getMessage());
        }
    }

    public static void validateLottoNumberBound(Integer numbers) {
        if (numbers < LOWER_BOUND || numbers > UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_BOUND_ERROR.getMessage());
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNumbersLength(numbers);
        numbers.forEach(Lotto::validateLottoNumberBound);
    }

    public Boolean containNumber(Integer number) {
        return this.lottoNumbers.contains(number);
    }

    public Boolean equals(Lotto lotto) {
        return this.lottoNumbers.equals(lotto.lottoNumbers);
    }
}
