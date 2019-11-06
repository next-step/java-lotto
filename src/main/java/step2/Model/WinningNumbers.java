package step2.Model;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static step2.Util.LottoUtil.*;

public class WinningNumbers {
    private static final String NUMBER_COUNT_EXCEPTION = "입력된 로또번호가 6개가 아닙니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION = "로또번호는 중복된 숫자를 허용하지 않습니다.";
    private static final String NUMBER_RANGE_EXCEPTION = "로또번호는 1 ~ 45 사이의 숫자입니다.";

    private Set<Integer> numbers;

    public WinningNumbers(String[] inputWinningNumbers) {
        verifyLottoNumberCount(inputWinningNumbers.length);
        Set<Integer> winningNumbers = Arrays.stream(inputWinningNumbers)
                .map(num -> Integer.parseInt(num.trim()))
                .collect(toSet());

        verifyLottoNumber(winningNumbers);
        this.numbers = winningNumbers;
    }

    private static void verifyLottoNumberCount(int length) {
        if (length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION);
        }
    }

    private static void verifyLottoNumber(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }

        if (winningNumbers.stream().anyMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
        }
    }

    boolean contains(Integer integer) {
        return numbers.contains(integer);
    }
}
