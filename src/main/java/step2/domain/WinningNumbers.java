package step2.domain;

import java.util.ArrayList;
import java.util.List;
import step2.utils.Conversion;
import step2.utils.Split;
import step2.utils.Validation;

public class WinningNumbers {

    private final List<Integer> numberList = new ArrayList<>();

    public WinningNumbers(String winningNumber) {
        String[] winningNumbers = Split.getStrings(winningNumber);
        List<Integer> numbers = Conversion.stringToInt(winningNumbers);
        validateWinningNumbers(numbers);
        this.numberList.addAll(numbers);
    }

    public WinningNumbers(List<Integer> winningNumbers) {
        this.numberList.addAll(winningNumbers);
    }

    public List<Integer> get() {
        return this.numberList;
    }

    public boolean confirm(int number) {
        return this.numberList.contains(number);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        Validation.duplicate(numbers);
        for (Integer number : numbers) {
            Validation.rangeOfNumber(number);
        }
    }
}
