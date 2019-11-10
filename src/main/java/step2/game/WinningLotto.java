package step2.game;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningLotto {
    private static final String NUMBER_COUNT_EXCEPTION = "입력된 로또번호가 6개가 아닙니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION = "로또번호는 중복된 숫자를 허용하지 않습니다.";

    private static final String DELIMITER = ",";

    private List<Number> numbers;
    private Number bonusNumber;

    public WinningLotto(String inputNumbers, int bonusNumber) {
        List<Number> inputWinningNumbers = Arrays.stream(inputNumbers.split(DELIMITER))
                .map(num -> Integer.parseInt(num.trim()))
                .map(num -> Number.valueOf(num))
                .collect(toList());
        verifyWinningNumberCount(inputWinningNumbers);
        verifyWinningNumberOrBonusNumber(inputWinningNumbers, bonusNumber);
        this.numbers = inputWinningNumbers;
        this.bonusNumber = Number.valueOf(bonusNumber);
    }

    boolean contains(Number integer) {
        return numbers.contains(integer);
    }

    boolean hasBonus(List<Number> userLotto) {
        return userLotto.contains(bonusNumber);
    }

    private void verifyWinningNumberCount(List<Number> inputWinningNumbers) {
        if (inputWinningNumbers.size() != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION);
        }
        if (inputWinningNumbers.stream().distinct().count() != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }
    }

    private void verifyWinningNumberOrBonusNumber(List<Number> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(Number.valueOf(bonusNumber))) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }
    }


}
