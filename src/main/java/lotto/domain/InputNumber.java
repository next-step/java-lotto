package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputNumber {
    public static final String DELIMITER = ", ";

    private final String winningNo;
    private final String bonusNo;

    public InputNumber(final String winningNo, final String bonusNo) {
        this.winningNo = winningNo;
        this.bonusNo = bonusNo;
    }

    public List<Number> winningNumbers() {
        List<Number> winningNumbers = new ArrayList<>();
        String[] numbers = winningNo.split(DELIMITER);
        for (String number : numbers) {
            winningNumbers.add(new Number(Integer.parseInt(number)));
        }
        return winningNumbers;
    }

    public int sumMatchCount(final List<Number> numbers) {
        int sum = 0;
        for (Number winningNumber : winningNumbers()) {
            sum = winningNumber.sum(sum, numbers);
        }
        return sum;
    }

    public boolean isMatchBonusNo(final List<Number> numbers) {
        boolean match = false;
        for (Number number : numbers) {
            match = Objects.equals(bonusNo, number.toString());
        }
        return match;
    }
}
