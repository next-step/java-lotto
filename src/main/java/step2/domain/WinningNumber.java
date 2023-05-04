package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Number> winningNumbers;
    private final Number bonusNumber;

    private WinningNumber(List<Number> winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber generate(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(integerToNumberList(winningNumbers), new Number(bonusNumber));
    }

    private static List<Number> integerToNumberList(List<Integer> winningNumbers) {
        List<Number> numbers = new ArrayList<>();

        for (Integer integer : winningNumbers) {
            numbers.add(new Number(integer));
        }

        return numbers;
    }

    public List<Number> winningNumbers() {
        return winningNumbers;
    }

    public Number bonusNumber() {
        return bonusNumber;
    }
}
