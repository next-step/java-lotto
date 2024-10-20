package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputNumber {
    public static final String DELIMITER = ", ";

    private final List<Number> winningNumbers;
    private final Number bonusNumber;

    public InputNumber(final String winningNo, final String bonusNo) {
        this.winningNumbers = winningNumbers(winningNo);
        this.bonusNumber = number(bonusNo);
    }


    private List<Number> winningNumbers(final String winningNo) {
        List<Number> winningNumbers = new ArrayList<>();
        String[] values = winningNo.split(DELIMITER);
        for (String value : values) {
            winningNumbers.add(number(value));
        }
        return winningNumbers;
    }

    private static Number number(final String value) {
        return new Number(Integer.parseInt(value));
    }

    public int countWinningNumbers(final List<Number> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean existBonusNumber(final Number number) {
        return Objects.equals(bonusNumber, number);
    }
}
