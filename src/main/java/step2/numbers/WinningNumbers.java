package step2.numbers;

import java.util.List;

public class WinningNumbers {
    private static final String DUPLICATED_NUMBER_EXCEPTION = "로또번호는 중복된 숫자를 허용하지 않습니다.";

    private List<Number> winningNumbers;

    WinningNumbers(String inputNumbers) {
        List<Number> inputWinningNumbers = InputNumbersUtil.toNumberList(inputNumbers);
        InputNumbersUtil.verifyLottoNumberCount(inputWinningNumbers);
        this.winningNumbers = inputWinningNumbers;
    }

    void verifyLottoNumberOrBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(Number.valueOf(bonusNumber))) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }
    }

    boolean contains(Number number) {
        return winningNumbers.contains(number);
    }
}
