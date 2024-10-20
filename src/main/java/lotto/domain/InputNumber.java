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
        this.bonusNumber = bonusNumber(bonusNo);
    }


    private List<Number> winningNumbers(final String winningNo) {
        List<Number> winningNumbers = new ArrayList<>();
        String[] numbers = winningNo.split(DELIMITER);
        for (String number : numbers) {
            winningNumbers.add(bonusNumber(number));
        }
        return winningNumbers;
    }

    private static Number bonusNumber(final String bonusNo) {
        return new Number(Integer.parseInt(bonusNo));
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
