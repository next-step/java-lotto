package step2.game;

import java.util.List;

public class WinningNumbers extends InputNumber {
    private static final String DUPLICATED_NUMBER_EXCEPTION = "로또번호는 중복된 숫자를 허용하지 않습니다.";

    private List<Number> winningNumbers;

    public WinningNumbers(String inputNumbers) {
        List<Number> inputWinningNumbers = toNumberList(inputNumbers);
        verifyLottoNumberCount(inputWinningNumbers);
        this.winningNumbers = inputWinningNumbers;
    }

    public void verifyLottoNumberOrBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(Number.valueOf(bonusNumber))) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }
    }

    public boolean contains(Number number) {
        return winningNumbers.contains(number);
    }
}
