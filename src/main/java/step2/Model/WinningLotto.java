package step2.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class WinningLotto {
    private static final String NUMBER_COUNT_EXCEPTION = "입력된 로또번호가 6개가 아닙니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION = "로또번호는 중복된 숫자를 허용하지 않습니다.";
    private static final String NUMBER_RANGE_EXCEPTION = "로또번호는 1 ~ 45 사이의 숫자입니다.";
    private static final String DELIMITER = ",";

    private Set<Integer> numbers;

    public WinningLotto(String inputNumbers) {
        List<String> inputWinningNumbers = Arrays.asList(inputNumbers.split(DELIMITER));
        verifyWinningNumberCount(inputWinningNumbers.size());
        Set<Integer> winningNumbers = inputWinningNumbers.stream()
                .map(num -> Integer.parseInt(num.trim()))
                .collect(toSet());
        verifyWinningNumber(winningNumbers);
        this.numbers = winningNumbers;
    }

    boolean contains(int integer) {
        return numbers.contains(integer);
    }

    private void verifyWinningNumberCount(int length) {
        if (length != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION);
        }
    }

    private void verifyWinningNumber(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }

        if (winningNumbers.stream().anyMatch(num -> num < LottoGame.MIN_NUMBER || num > LottoGame.MAX_NUMBER)) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
        }
    }


}
