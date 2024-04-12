package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static List<Integer> parseLottoNumbers(String lottoNumber) {
        try {
            return Arrays.stream(
                    lottoNumber.replaceAll("\\s", "").split(",")
            ).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NUMERIC_ERROR.getMessage());
        }
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
}
